package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private final String f31337a;

    /* renamed from: b, reason: collision with root package name */
    private final vb.g f31338b;

    public y(String str, vb.g gVar) {
        this.f31337a = str;
        this.f31338b = gVar;
    }

    private File b() {
        return this.f31338b.g(this.f31337a);
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e11) {
            ob.g.f().e("Error creating marker: " + this.f31337a, e11);
            return false;
        }
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
