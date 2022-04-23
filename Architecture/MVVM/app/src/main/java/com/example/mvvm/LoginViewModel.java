package com.example.mvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

public class LoginViewModel extends BaseObservable {
    private String email;
    private String password;
    public ObservableField<String> messageLogin = new ObservableField<>();
    public ObservableField<Boolean> isShowMessage = new ObservableField<>();
    public ObservableField<Boolean> isSuccess = new ObservableField<>();

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void onClickLogin() {
        User user = new User(getEmail(), getPassword());
        isShowMessage.set(true);
        if(user.isValidEmail() && user.isValidPassword()){
            messageLogin.set("Đăng nhập thành công");
            isSuccess.set(true);
        }else{
            messageLogin.set("Đăng nhập không thành công");
            isSuccess.set(false);
        }
    }
}
