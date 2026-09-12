package com.google.android.exoplayer2.upstream;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private final Map f27586a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map f27587b;

    public synchronized Map a() {
        try {
            if (this.f27587b == null) {
                this.f27587b = Collections.unmodifiableMap(new HashMap(this.f27586a));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f27587b;
    }
}
