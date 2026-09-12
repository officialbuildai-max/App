package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.emoji2.text.flatbuffer.c f9212a;

    /* renamed from: b, reason: collision with root package name */
    private final char[] f9213b;

    /* renamed from: c, reason: collision with root package name */
    private final a f9214c = new a(1024);

    /* renamed from: d, reason: collision with root package name */
    private final Typeface f9215d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final SparseArray f9216a;

        /* renamed from: b, reason: collision with root package name */
        private p f9217b;

        private a() {
            this(1);
        }

        a(int i11) {
            this.f9216a = new SparseArray(i11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(int i11) {
            SparseArray sparseArray = this.f9216a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final p b() {
            return this.f9217b;
        }

        void c(p pVar, int i11, int i12) {
            a a11 = a(pVar.b(i11));
            if (a11 == null) {
                a11 = new a();
                this.f9216a.put(pVar.b(i11), a11);
            }
            if (i12 > i11) {
                a11.c(pVar, i11 + 1, i12);
            } else {
                a11.f9217b = pVar;
            }
        }
    }

    private n(Typeface typeface, androidx.emoji2.text.flatbuffer.c cVar) {
        this.f9215d = typeface;
        this.f9212a = cVar;
        this.f9213b = new char[cVar.l() * 2];
        a(cVar);
    }

    private void a(androidx.emoji2.text.flatbuffer.c cVar) {
        int l11 = cVar.l();
        for (int i11 = 0; i11 < l11; i11++) {
            p pVar = new p(this, i11);
            Character.toChars(pVar.f(), this.f9213b, i11 * 2);
            h(pVar);
        }
    }

    public static n b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            androidx.core.os.s.a("EmojiCompat.MetadataRepo.create");
            return new n(typeface, m.b(byteBuffer));
        } finally {
            androidx.core.os.s.b();
        }
    }

    public char[] c() {
        return this.f9213b;
    }

    public androidx.emoji2.text.flatbuffer.c d() {
        return this.f9212a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f9212a.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a f() {
        return this.f9214c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Typeface g() {
        return this.f9215d;
    }

    void h(p pVar) {
        androidx.core.util.i.h(pVar, "emoji metadata cannot be null");
        androidx.core.util.i.b(pVar.c() > 0, "invalid metadata codepoint length");
        this.f9214c.c(pVar, 0, pVar.c() - 1);
    }
}
