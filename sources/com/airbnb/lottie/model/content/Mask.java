package com.airbnb.lottie.model.content;

import q4.d;
import q4.h;

/* loaded from: classes2.dex */
public class Mask {

    /* renamed from: a, reason: collision with root package name */
    private final MaskMode f17866a;

    /* renamed from: b, reason: collision with root package name */
    private final h f17867b;

    /* renamed from: c, reason: collision with root package name */
    private final d f17868c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f17869d;

    /* loaded from: classes.dex */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, h hVar, d dVar, boolean z10) {
        this.f17866a = maskMode;
        this.f17867b = hVar;
        this.f17868c = dVar;
        this.f17869d = z10;
    }

    public MaskMode a() {
        return this.f17866a;
    }

    public h b() {
        return this.f17867b;
    }

    public d c() {
        return this.f17868c;
    }

    public boolean d() {
        return this.f17869d;
    }
}
