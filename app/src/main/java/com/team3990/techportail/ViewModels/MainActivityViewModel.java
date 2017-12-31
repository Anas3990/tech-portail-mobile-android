package com.team3990.techportail.ViewModels;

import android.arch.lifecycle.ViewModel;

/**
 * Created by Anas Merbouh on 17-12-31.
 */


public class MainActivityViewModel extends ViewModel {

    private boolean mIsSigningIn;

    public MainActivityViewModel() {
        mIsSigningIn = false;
    }

    public boolean getIsSigningIn() {
        return mIsSigningIn;
    }

    public void setIsSigningIn(boolean mIsSigningIn) {
        this.mIsSigningIn = mIsSigningIn;
    }
}
