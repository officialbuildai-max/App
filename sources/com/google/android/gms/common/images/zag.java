package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zam;

/* loaded from: classes3.dex */
public abstract class zag {
    final zad zaa;
    protected int zab;

    public zag(Uri uri, int i11) {
        this.zab = 0;
        this.zaa = new zad(uri);
        this.zab = i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zaa(@Nullable Drawable drawable, boolean z10, boolean z11, boolean z12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zab(Context context, zam zamVar, boolean z10) {
        int i11 = this.zab;
        zaa(i11 != 0 ? context.getResources().getDrawable(i11) : null, z10, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zac(Context context, Bitmap bitmap, boolean z10) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
