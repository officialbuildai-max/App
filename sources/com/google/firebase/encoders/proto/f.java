package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f implements bc.f {

    /* renamed from: a, reason: collision with root package name */
    private boolean f31893a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f31894b = false;

    /* renamed from: c, reason: collision with root package name */
    private bc.b f31895c;

    /* renamed from: d, reason: collision with root package name */
    private final d f31896d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.f31896d = dVar;
    }

    private void a() {
        if (this.f31893a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f31893a = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(bc.b bVar, boolean z10) {
        this.f31893a = false;
        this.f31895c = bVar;
        this.f31894b = z10;
    }

    @Override // bc.f
    public bc.f f(String str) {
        a();
        this.f31896d.i(this.f31895c, str, this.f31894b);
        return this;
    }

    @Override // bc.f
    public bc.f g(boolean z10) {
        a();
        this.f31896d.o(this.f31895c, z10, this.f31894b);
        return this;
    }
}
