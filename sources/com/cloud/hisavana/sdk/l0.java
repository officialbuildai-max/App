package com.cloud.hisavana.sdk;

import android.os.Bundle;

/* loaded from: classes3.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    protected Bundle f22693a = new Bundle();

    /* renamed from: b, reason: collision with root package name */
    protected int f22694b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected int f22695c = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.f22693a.putInt("s_material_cache", 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i11) {
        if (i11 == 250) {
            this.f22695c = 2;
        } else {
            this.f22695c = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(boolean z10) {
        if (z10) {
            this.f22693a.putInt("s_material_cache", 1);
        } else {
            this.f22693a.putInt("s_material_cache", 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        if (this.f22695c == 1 || this.f22694b == 1) {
            this.f22693a.putInt("s_material_cache", 1);
        } else {
            this.f22693a.putInt("s_material_cache", 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i11) {
        if (i11 == 250) {
            this.f22693a.putInt("s_material_cache", 2);
        } else {
            this.f22693a.putInt("s_material_cache", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i11) {
        if (i11 == 250) {
            this.f22694b = 2;
        } else {
            this.f22694b = 1;
        }
    }
}
