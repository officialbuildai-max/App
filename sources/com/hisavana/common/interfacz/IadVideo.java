package com.hisavana.common.interfacz;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public interface IadVideo {
    boolean canShow();

    boolean isLoaded();

    void show(WeakReference<Context> weakReference, String str, String str2);
}
