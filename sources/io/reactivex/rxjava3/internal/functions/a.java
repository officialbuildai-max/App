package io.reactivex.rxjava3.internal.functions;

import java.util.Objects;
import lz.d;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    static final d f65456a = new C0819a();

    /* renamed from: io.reactivex.rxjava3.internal.functions.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static final class C0819a implements d {
        C0819a() {
        }

        @Override // lz.d
        public boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }
    }

    public static int a(int i11, String str) {
        if (i11 > 0) {
            return i11;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i11);
    }
}
