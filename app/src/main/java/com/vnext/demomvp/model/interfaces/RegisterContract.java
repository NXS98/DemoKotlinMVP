package com.vnext.demomvp.model.interfaces;

public interface RegisterContract {
    public interface View{
        void registerSuccess(String messsage);
        void registerFailure();
    }
    public interface Presenter{
        public void handleRegister(String username,String password);
    }
}
