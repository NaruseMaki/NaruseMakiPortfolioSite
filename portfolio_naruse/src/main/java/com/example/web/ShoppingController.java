package com.example.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.Account;
import com.example.domain.Cart;
import com.example.domain.Products;
import com.example.service.AccountService;
import com.example.service.CartService;
import com.example.service.LoginUserDetails;
import com.example.service.LoginUserDetailsService;
import com.example.service.ProductsService;


@Controller
@RequestMapping("shopping") /*これをつけるとURLが『http://localhost:8080/shopping』から始まるようになる*/
public class ShoppingController {
	@Autowired
	ProductsService productsService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	LoginUserDetailsService loginUserDetailsService;
	
	
	//index画面を表示するためのメソッド
    @GetMapping
    public String index(Model model, Pageable pageable) {
        Page<Products> productsPage = productsService.findAll(pageable);
        model.addAttribute("page", productsPage);
        model.addAttribute("products", productsPage.getContent());
        model.addAttribute("url", "shopping");

        return "shopping/index";
    }
    
    //カテゴリー"本"のものだけを表示させるメソッド
    @GetMapping(path="book")
    public String book(Model model, Pageable pageable) {
    	String category = "本";
        Page<Products> productsPage = productsService.findByCategryEquals(category, pageable);
        model.addAttribute("page", productsPage);
        model.addAttribute("products", productsPage.getContent());
        return "shopping/index";
    }
    
    //カテゴリー"食品"のものだけを表示させるメソッド
    @GetMapping(path="food")
    public String food(Model model, Pageable pageable) {
    	String category = "食品";
        Page<Products> productsPage = productsService.findByCategryEquals(category, pageable);
        model.addAttribute("page", productsPage);
        model.addAttribute("products", productsPage.getContent());
        return "shopping/index";
    }
    
    //カテゴリー"ゲーム"のものだけを表示させるメソッド
    @GetMapping(path="game")
    public String game(Model model, Pageable pageable) {
    	String category = "ゲーム";
        Page<Products> productsPage = productsService.findByCategryEquals(category, pageable);
        model.addAttribute("page", productsPage);
        model.addAttribute("products", productsPage.getContent());
        return "shopping/index";
    }
    
    //カテゴリー"家電"のものだけを表示させるメソッド
    @GetMapping(path="kaden")
    public String kaden(Model model, Pageable pageable) {
    	String category = "家電";
        Page<Products> productsPage = productsService.findByCategryEquals(category, pageable);
        model.addAttribute("page", productsPage);
        model.addAttribute("products", productsPage.getContent());
        return "shopping/index";
    }
    
    
    //カートを画面に表示する用のメソッド
    @GetMapping(path="cart")
    public String cart(Model model, Pageable pageable, @AuthenticationPrincipal LoginUserDetails userDetails) {
    	Account account = userDetails.getAccount();
    	Integer accountid = account.getId();
    	Page<Cart> cartPage = cartService.findByAccountidEquals(accountid, pageable);
    	//カートに物が入ってるか判別するためのリスト
    	List<Cart> myCart = cartService.findByAccountidEquals(accountid);
    	model.addAttribute("page", cartPage);
       	model.addAttribute("cart", cartPage);
        //カートに何個商品が入っているか送る
       	model.addAttribute("anyNumber", myCart.size());
        return "shopping/cart";
    }
    
    //カートに商品を入れる用のメソッド
    @PostMapping(path="cart")
    public String cartIn(@RequestParam Integer id, @AuthenticationPrincipal LoginUserDetails userDetails) {
    	Integer count = 1;
    	Account account = userDetails.getAccount();
    	Integer accountid = account.getId();
    	Products products = productsService.findByIdEquals(id);
    	//今ログインしている個人のidと、選択した商品のidを送る
    	Cart mycart = cartService.findByAccountidAndProductsid(accountid, products.getId());
    	
    	//mycartに同じ商品が入っていたらその商品の個数を増やす
    	if(mycart != null) {
    		//同じ商品の個数を10個以上増やせないようにする
    		if(mycart.getCount() < 10){
    			mycart.setCount(mycart.getCount()+1);
    		}
    		cartService.update(mycart);
    		
    	//mycartに同じ商品が入っていなかったらカートに入れる
    	} else {
    		Cart newcart = new Cart(accountid, products.getId(), products.getName(), products.getPrice(), products.getMaker(), products.getCategory(), count);
    		cartService.create(newcart);
   		}
    	
    	return "redirect:/shopping/cart";
    }
    
    //カート内商品の個数を増やすメソッド
    @PostMapping(path="cartdecrement")
    public String cartdecrement(@RequestParam Integer id) {
    	//送られてきたカートIDでカート内の商品を探す
    	Cart cart = cartService.findOne(id);
    	
    	//同じ商品の個数を10個以上増やせないようにする
    	if(cart.getCount() < 10){
    		cart.setCount(cart.getCount()+1);
    	}
    	cartService.update(cart);
    	return "redirect:/shopping/cart";
    }
    
    //カート内商品の個数を減らすメソッド
    @PostMapping(path="cartincrement")
    public String cartincrement(@RequestParam Integer id) {
    	//送られてきたカートIDでカート内の商品を探す
    	Cart cart = cartService.findOne(id);
    	
    	//同じ商品の個数を1個以下に減らせないようにする
    	if(cart.getCount() <= 1){
    		cart.setCount(cart.getCount());
   		} else {
   			cart.setCount(cart.getCount()-1);
   		}
    	cartService.update(cart);
    	return "redirect:/shopping/cart";
    }
    
    //カート内の商品を削除するためのメソッド
    @PostMapping(path = "delete")
    String delete(@RequestParam Integer id) {
        cartService.delete(id);
        return "redirect:/shopping/cart";
    }
    
    
    //購入確認画面へ進むメソッド
    @GetMapping(path="buy")
    public String buy(Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {
    	Account account = userDetails.getAccount();
    	Integer accountid = account.getId();
    	List<Cart> myCart = cartService.findByAccountidEquals(accountid);
    	//MYカートの情報を送る
       	model.addAttribute("cart", myCart);
        //MYカートに何個商品が入っているか送る
       	model.addAttribute("anyNumber", myCart.size());
       	
       	//MYカートの総合計金額と総商品数を出しておく
       	Integer total = 0;
       	Integer totalcount = 0;
       	for(Integer i=0; i<myCart.size(); i++) {
       		total += myCart.get(i).getPrice() * myCart.get(i).getCount();
       		totalcount += myCart.get(i).getCount();
       	}
       	model.addAttribute("total", total);
       	model.addAttribute("totalcount", totalcount);
       	
        return "shopping/buy";
    }

    //お客さんの情報を表示させるメソッド
    @PostMapping(path = "confirm")
    public String confirm(Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {
    	Account account = userDetails.getAccount();
    	Integer accountid = account.getId();
    	//データベースに入っている個人のアカウント情報を取得する
    	Account myAccount = accountService.findByIdEquals(accountid);
    	//カートに物が入ってるか判別するためのリスト
    	List<Cart> myCart = cartService.findByAccountidEquals(accountid);
    	//MYカートの情報を送る
       	model.addAttribute("cart", myCart);
        //MYカートに何個商品が入っているか送る
       	model.addAttribute("anyNumber", myCart.size());
       	//お客さんの情報を送る
    	model.addAttribute("myaccount", myAccount);
    	return "shopping/confirm";
    }
    
    //購入完了画面を表示するメソッド
    @PostMapping(path = "result")
    public String result(Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {
    	//今現在カートに入っている商品を取得する
    	Account account = userDetails.getAccount();
    	Integer accountid = account.getId();
    	Account myAccount = accountService.findByIdEquals(accountid);
    	List<Cart> myCart = cartService.findByAccountidEquals(myAccount.getId());
    	
    	//個人のカートに入っている商品を全て削除する
    	for(int i=0; i<myCart.size(); i++) {
    		cartService.delete(myCart.get(i).getCartid());
    	}
    	
    	//購入完了メッセージを送る
    	model.addAttribute("msg", "商品の購入が完了しました。ありがとうございました。");
    	return "shopping/result";
    }
    
    
    //お客様情報編集画面を表示するメソッド
    @GetMapping(path = "accountedit")
    public String accountEdit(Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {
    	//データベースに入っているお客さんの情報を取得する
    	Account account = userDetails.getAccount();
    	Account myAccount = accountService.findByIdEquals(account.getId());
    	//編集用のアカウントフォームを呼び出す
    	AccountEditForm accounteditform = new  AccountEditForm(myAccount.getName(), myAccount.getAddress());
    	//編集用のアカウントフォームを送る
    	model.addAttribute("accountEditForm", accounteditform);
    	return "shopping/accountedit";
    }
    
    //お客様情報を編集するメソッド
    @PostMapping(path = "accountedit")
    public String accountEditPost(Model model, @Valid AccountEditForm accountEditForm, BindingResult bindingResult, @AuthenticationPrincipal LoginUserDetails userDetails) {
    	//データベースに入っているお客さんの情報を取得する
    	Account myAccount = accountService.findByIdEquals(userDetails.getAccount().getId());
    	
    	//エラーの場合は編集画面に飛ばす
    	if (bindingResult.hasErrors()) {
            return "shopping/accountedit";
        }
    	
    	//アカウントフォームに入力された情報を『ログインユーザーディティールズサービス』というクラスに送る
    	try {
        	loginUserDetailsService.registerUserEdit(myAccount.getId(), myAccount.getLoginid(), accountEditForm.getName(), myAccount.getPass(), accountEditForm.getAddress());
        
        //エラーの場合は編集画面に飛ばす
    	} catch (DataIntegrityViolationException e) {
            model.addAttribute("accounteditError", true);
            return "shopping/accountedit";
        }
 
    	return "redirect:/shopping/buy";
    }
    
    
    //トップに戻るためのメソッド
    @GetMapping(path = "goToTop")
    String goToTop() {
        return "redirect:/shopping";
    }
    
}
