--------springフレームワークで作ったデモECサイト--------

◎画面一覧
・ログインフォーム
・アカウント新規作成画面
・商品一覧画面
・カート画面
・購入確認画面
・アカウント編集画面
・購入完了画面
・ログアウト機能


◎使い方
1. 【MAMP】というローカルで動作するサーバーを起動させておきます。
2. MAMPの phpMyAdmin で【portfolio】という名前のデータベースを作ります。※テーブルじゃなくてデータベースです。
3. 一緒のzipファイルに同封した【portfolio_naruse.sql】を先ほど作った【portfolio】でインポートします。
4. stsで【portfolio_naruse】ファイルをインポートします。
5. 【PortfilioNaruseApplication.java】を実行します。
6. 好きなブラウザで【http://localhost:8080/loginForm】とアドレスを入力すればポートフォリオサイトが見られるようになります。