package com.blankj.utilcode.util;

import android.app.Application;
import androidx.core.content.FileProvider;

/* loaded from: classes.dex */
public class UtilsFileProvider extends FileProvider {
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        Utils.b((Application) getContext().getApplicationContext());
        return true;
    }
}
