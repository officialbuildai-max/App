package org.apache.tools.ant.util;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* loaded from: classes7.dex */
public class b {

    /* loaded from: classes7.dex */
    private static final class a implements Enumeration {

        /* renamed from: a, reason: collision with root package name */
        private final Enumeration f71674a;

        /* renamed from: b, reason: collision with root package name */
        private final Enumeration f71675b;

        public a(Enumeration enumeration, Enumeration enumeration2) {
            this.f71674a = enumeration;
            this.f71675b = enumeration2;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f71674a.hasMoreElements() || this.f71675b.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return this.f71674a.hasMoreElements() ? this.f71674a.nextElement() : this.f71675b.nextElement();
        }
    }

    /* renamed from: org.apache.tools.ant.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0894b implements Enumeration {
        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            throw new NoSuchElementException();
        }
    }

    public static Enumeration a(Enumeration enumeration, Enumeration enumeration2) {
        return new a(enumeration, enumeration2);
    }
}
