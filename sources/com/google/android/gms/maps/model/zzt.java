package com.google.android.gms.maps.model;

import com.google.android.gms.internal.maps.zzag;

/* loaded from: classes4.dex */
final class zzt extends zzag {
    private final /* synthetic */ TileProvider zzen;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
        this.zzen = tileProvider;
    }

    @Override // com.google.android.gms.internal.maps.zzaf
    public final Tile getTile(int i11, int i12, int i13) {
        return this.zzen.getTile(i11, i12, i13);
    }
}
