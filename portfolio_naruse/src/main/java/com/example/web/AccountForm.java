package com.example.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountForm {
    @NotNull
    @Size(min = 5, max = 30)
    @Pattern(regexp="^\\w{5,30}$", message="\n" + "文字数は5〜30文字以内で設定してください。各文字は半角英数字またはアンダースコア（a~z 0~9 _）で設定してください。")
    private String loginid;
    @NotNull
    @Size(min = 1, max = 30)
    //@Pattern(regexp="^\\w{3,32}$", message="size must be between 3 and 32, each character must be alphanumeric or underscore (A-Za-z0-9_)")
    private String name;
    @NotNull
    @Size(min = 5, max = 20)
    @Pattern(regexp="^\\w{5,20}$", message="\n" + "文字数は5〜20文字以内で設定してください。各文字は半角英数字またはアンダースコア（a~z 0~9 _）で設定してください。")
    private String pass;
    @NotNull
    @Size(min = 5, max = 200)
    private String address;
}