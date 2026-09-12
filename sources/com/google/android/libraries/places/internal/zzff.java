package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.android.volley.i;
import com.android.volley.toolbox.i;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzff extends i {
    final /* synthetic */ Map zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzff(zzfg zzfgVar, String str, i.b bVar, int i11, int i12, ImageView.ScaleType scaleType, Bitmap.Config config, i.a aVar, Map map) {
        super(str, bVar, 0, 0, scaleType, config, aVar);
        this.zza = map;
    }

    @Override // com.android.volley.Request
    public final Map getHeaders() {
        return this.zza;
    }
}
