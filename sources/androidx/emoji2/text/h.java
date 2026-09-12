package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.n;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final EmojiCompat.i f9173a;

    /* renamed from: b, reason: collision with root package name */
    private final n f9174b;

    /* renamed from: c, reason: collision with root package name */
    private EmojiCompat.e f9175c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f9176d;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f9177e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        static int a(CharSequence charSequence, int i11, int i12) {
            int length = charSequence.length();
            if (i11 < 0 || length < i11 || i12 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i12 != 0) {
                    i11--;
                    if (i11 < 0) {
                        return z10 ? -1 : 0;
                    }
                    char charAt = charSequence.charAt(i11);
                    if (z10) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i12--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i12--;
                    } else {
                        if (Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        z10 = true;
                    }
                }
                return i11;
            }
        }

        static int b(CharSequence charSequence, int i11, int i12) {
            int length = charSequence.length();
            if (i11 < 0 || length < i11 || i12 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i12 != 0) {
                    if (i11 >= length) {
                        if (z10) {
                            return -1;
                        }
                        return length;
                    }
                    char charAt = charSequence.charAt(i11);
                    if (z10) {
                        if (!Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i12--;
                        i11++;
                    } else if (!Character.isSurrogate(charAt)) {
                        i12--;
                        i11++;
                    } else {
                        if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i11++;
                        z10 = true;
                    }
                }
                return i11;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public t f9178a;

        /* renamed from: b, reason: collision with root package name */
        private final EmojiCompat.i f9179b;

        b(t tVar, EmojiCompat.i iVar) {
            this.f9178a = tVar;
            this.f9179b = iVar;
        }

        @Override // androidx.emoji2.text.h.c
        public boolean b(CharSequence charSequence, int i11, int i12, p pVar) {
            if (pVar.k()) {
                return true;
            }
            if (this.f9178a == null) {
                this.f9178a = new t(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            this.f9178a.setSpan(this.f9179b.a(pVar), i11, i12, 33);
            return true;
        }

        @Override // androidx.emoji2.text.h.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public t a() {
            return this.f9178a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        Object a();

        boolean b(CharSequence charSequence, int i11, int i12, p pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements c {

        /* renamed from: a, reason: collision with root package name */
        private final String f9180a;

        d(String str) {
            this.f9180a = str;
        }

        @Override // androidx.emoji2.text.h.c
        public boolean b(CharSequence charSequence, int i11, int i12, p pVar) {
            if (!TextUtils.equals(charSequence.subSequence(i11, i12), this.f9180a)) {
                return true;
            }
            pVar.l(true);
            return false;
        }

        @Override // androidx.emoji2.text.h.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public d a() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private int f9181a = 1;

        /* renamed from: b, reason: collision with root package name */
        private final n.a f9182b;

        /* renamed from: c, reason: collision with root package name */
        private n.a f9183c;

        /* renamed from: d, reason: collision with root package name */
        private n.a f9184d;

        /* renamed from: e, reason: collision with root package name */
        private int f9185e;

        /* renamed from: f, reason: collision with root package name */
        private int f9186f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f9187g;

        /* renamed from: h, reason: collision with root package name */
        private final int[] f9188h;

        e(n.a aVar, boolean z10, int[] iArr) {
            this.f9182b = aVar;
            this.f9183c = aVar;
            this.f9187g = z10;
            this.f9188h = iArr;
        }

        private static boolean d(int i11) {
            return i11 == 65039;
        }

        private static boolean f(int i11) {
            return i11 == 65038;
        }

        private int g() {
            this.f9181a = 1;
            this.f9183c = this.f9182b;
            this.f9186f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f9183c.b().j() || d(this.f9185e)) {
                return true;
            }
            if (this.f9187g) {
                if (this.f9188h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f9188h, this.f9183c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i11) {
            n.a a11 = this.f9183c.a(i11);
            int i12 = 2;
            if (this.f9181a != 2) {
                if (a11 == null) {
                    i12 = g();
                } else {
                    this.f9181a = 2;
                    this.f9183c = a11;
                    this.f9186f = 1;
                }
            } else if (a11 != null) {
                this.f9183c = a11;
                this.f9186f++;
            } else if (f(i11)) {
                i12 = g();
            } else if (!d(i11)) {
                if (this.f9183c.b() != null) {
                    i12 = 3;
                    if (this.f9186f != 1) {
                        this.f9184d = this.f9183c;
                        g();
                    } else if (h()) {
                        this.f9184d = this.f9183c;
                        g();
                    } else {
                        i12 = g();
                    }
                } else {
                    i12 = g();
                }
            }
            this.f9185e = i11;
            return i12;
        }

        p b() {
            return this.f9183c.b();
        }

        p c() {
            return this.f9184d.b();
        }

        boolean e() {
            return this.f9181a == 2 && this.f9183c.b() != null && (this.f9186f > 1 || h());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(n nVar, EmojiCompat.i iVar, EmojiCompat.e eVar, boolean z10, int[] iArr, Set set) {
        this.f9173a = iVar;
        this.f9174b = nVar;
        this.f9175c = eVar;
        this.f9176d = z10;
        this.f9177e = iArr;
        g(set);
    }

    private static boolean a(Editable editable, KeyEvent keyEvent, boolean z10) {
        i[] iVarArr;
        if (f(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!e(selectionStart, selectionEnd) && (iVarArr = (i[]) editable.getSpans(selectionStart, selectionEnd, i.class)) != null && iVarArr.length > 0) {
            for (i iVar : iVarArr) {
                int spanStart = editable.getSpanStart(iVar);
                int spanEnd = editable.getSpanEnd(iVar);
                if ((z10 && spanStart == selectionStart) || ((!z10 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(InputConnection inputConnection, Editable editable, int i11, int i12, boolean z10) {
        int max;
        int min;
        if (editable != null && inputConnection != null && i11 >= 0 && i12 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (e(selectionStart, selectionEnd)) {
                return false;
            }
            if (z10) {
                max = a.a(editable, selectionStart, Math.max(i11, 0));
                min = a.b(editable, selectionEnd, Math.max(i12, 0));
                if (max == -1 || min == -1) {
                    return false;
                }
            } else {
                max = Math.max(selectionStart - i11, 0);
                min = Math.min(selectionEnd + i12, editable.length());
            }
            i[] iVarArr = (i[]) editable.getSpans(max, min, i.class);
            if (iVarArr != null && iVarArr.length > 0) {
                for (i iVar : iVarArr) {
                    int spanStart = editable.getSpanStart(iVar);
                    int spanEnd = editable.getSpanEnd(iVar);
                    max = Math.min(spanStart, max);
                    min = Math.max(spanEnd, min);
                }
                int max2 = Math.max(max, 0);
                int min2 = Math.min(min, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max2, min2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Editable editable, int i11, KeyEvent keyEvent) {
        if (!(i11 != 67 ? i11 != 112 ? false : a(editable, keyEvent, true) : a(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean d(CharSequence charSequence, int i11, int i12, p pVar) {
        if (pVar.d() == 0) {
            pVar.m(this.f9175c.a(charSequence, i11, i12, pVar.h()));
        }
        return pVar.d() == 2;
    }

    private static boolean e(int i11, int i12) {
        return i11 == -1 || i12 == -1 || i11 != i12;
    }

    private static boolean f(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    private void g(Set set) {
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            i(str, 0, str.length(), 1, true, new d(str));
        }
    }

    private Object i(CharSequence charSequence, int i11, int i12, int i13, boolean z10, c cVar) {
        int i14;
        e eVar = new e(this.f9174b.f(), this.f9176d, this.f9177e);
        int i15 = 0;
        boolean z11 = true;
        int codePointAt = Character.codePointAt(charSequence, i11);
        loop0: while (true) {
            i14 = i11;
            while (i11 < i12 && i15 < i13 && z11) {
                int a11 = eVar.a(codePointAt);
                if (a11 == 1) {
                    i14 += Character.charCount(Character.codePointAt(charSequence, i14));
                    if (i14 < i12) {
                        codePointAt = Character.codePointAt(charSequence, i14);
                    }
                    i11 = i14;
                } else if (a11 == 2) {
                    i11 += Character.charCount(codePointAt);
                    if (i11 < i12) {
                        codePointAt = Character.codePointAt(charSequence, i11);
                    }
                } else if (a11 == 3) {
                    if (z10 || !d(charSequence, i14, i11, eVar.c())) {
                        z11 = cVar.b(charSequence, i14, i11, eVar.c());
                        i15++;
                    }
                }
            }
        }
        if (eVar.e() && i15 < i13 && z11 && (z10 || !d(charSequence, i14, i11, eVar.b()))) {
            cVar.b(charSequence, i14, i11, eVar.b());
        }
        return cVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049 A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:51:0x000e, B:54:0x0013, B:56:0x0017, B:58:0x0024, B:9:0x003a, B:11:0x0042, B:13:0x0045, B:15:0x0049, B:17:0x0055, B:19:0x0058, B:24:0x0066, B:30:0x0074, B:31:0x0080, B:33:0x0094, B:6:0x002f), top: B:50:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094 A[Catch: all -> 0x002a, TRY_LEAVE, TryCatch #0 {all -> 0x002a, blocks: (B:51:0x000e, B:54:0x0013, B:56:0x0017, B:58:0x0024, B:9:0x003a, B:11:0x0042, B:13:0x0045, B:15:0x0049, B:17:0x0055, B:19:0x0058, B:24:0x0066, B:30:0x0074, B:31:0x0080, B:33:0x0094, B:6:0x002f), top: B:50:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.CharSequence h(java.lang.CharSequence r11, int r12, int r13, int r14, boolean r15) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof androidx.emoji2.text.o
            if (r0 == 0) goto La
            r1 = r11
            androidx.emoji2.text.o r1 = (androidx.emoji2.text.o) r1
            r1.a()
        La:
            java.lang.Class<androidx.emoji2.text.i> r1 = androidx.emoji2.text.i.class
            if (r0 != 0) goto L2f
            boolean r2 = r11 instanceof android.text.Spannable     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L13
            goto L2f
        L13:
            boolean r2 = r11 instanceof android.text.Spanned     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L2d
            r2 = r11
            android.text.Spanned r2 = (android.text.Spanned) r2     // Catch: java.lang.Throwable -> L2a
            int r3 = r12 + (-1)
            int r4 = r13 + 1
            int r2 = r2.nextSpanTransition(r3, r4, r1)     // Catch: java.lang.Throwable -> L2a
            if (r2 > r13) goto L2d
            androidx.emoji2.text.t r2 = new androidx.emoji2.text.t     // Catch: java.lang.Throwable -> L2a
            r2.<init>(r11)     // Catch: java.lang.Throwable -> L2a
            goto L37
        L2a:
            r12 = move-exception
            goto Lb2
        L2d:
            r2 = 0
            goto L37
        L2f:
            androidx.emoji2.text.t r2 = new androidx.emoji2.text.t     // Catch: java.lang.Throwable -> L2a
            r3 = r11
            android.text.Spannable r3 = (android.text.Spannable) r3     // Catch: java.lang.Throwable -> L2a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2a
        L37:
            r3 = 0
            if (r2 == 0) goto L63
            java.lang.Object[] r4 = r2.getSpans(r12, r13, r1)     // Catch: java.lang.Throwable -> L2a
            androidx.emoji2.text.i[] r4 = (androidx.emoji2.text.i[]) r4     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L63
            int r5 = r4.length     // Catch: java.lang.Throwable -> L2a
            if (r5 <= 0) goto L63
            int r5 = r4.length     // Catch: java.lang.Throwable -> L2a
            r6 = r3
        L47:
            if (r6 >= r5) goto L63
            r7 = r4[r6]     // Catch: java.lang.Throwable -> L2a
            int r8 = r2.getSpanStart(r7)     // Catch: java.lang.Throwable -> L2a
            int r9 = r2.getSpanEnd(r7)     // Catch: java.lang.Throwable -> L2a
            if (r8 == r13) goto L58
            r2.removeSpan(r7)     // Catch: java.lang.Throwable -> L2a
        L58:
            int r12 = java.lang.Math.min(r8, r12)     // Catch: java.lang.Throwable -> L2a
            int r13 = java.lang.Math.max(r9, r13)     // Catch: java.lang.Throwable -> L2a
            int r6 = r6 + 1
            goto L47
        L63:
            r4 = r13
            if (r12 == r4) goto La9
            int r13 = r11.length()     // Catch: java.lang.Throwable -> L2a
            if (r12 < r13) goto L6d
            goto La9
        L6d:
            r13 = 2147483647(0x7fffffff, float:NaN)
            if (r14 == r13) goto L80
            if (r2 == 0) goto L80
            int r13 = r2.length()     // Catch: java.lang.Throwable -> L2a
            java.lang.Object[] r13 = r2.getSpans(r3, r13, r1)     // Catch: java.lang.Throwable -> L2a
            androidx.emoji2.text.i[] r13 = (androidx.emoji2.text.i[]) r13     // Catch: java.lang.Throwable -> L2a
            int r13 = r13.length     // Catch: java.lang.Throwable -> L2a
            int r14 = r14 - r13
        L80:
            r5 = r14
            androidx.emoji2.text.h$b r7 = new androidx.emoji2.text.h$b     // Catch: java.lang.Throwable -> L2a
            androidx.emoji2.text.EmojiCompat$i r13 = r10.f9173a     // Catch: java.lang.Throwable -> L2a
            r7.<init>(r2, r13)     // Catch: java.lang.Throwable -> L2a
            r1 = r10
            r2 = r11
            r3 = r12
            r6 = r15
            java.lang.Object r12 = r1.i(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L2a
            androidx.emoji2.text.t r12 = (androidx.emoji2.text.t) r12     // Catch: java.lang.Throwable -> L2a
            if (r12 == 0) goto La0
            android.text.Spannable r12 = r12.b()     // Catch: java.lang.Throwable -> L2a
            if (r0 == 0) goto L9f
            androidx.emoji2.text.o r11 = (androidx.emoji2.text.o) r11
            r11.d()
        L9f:
            return r12
        La0:
            if (r0 == 0) goto La8
            r12 = r11
            androidx.emoji2.text.o r12 = (androidx.emoji2.text.o) r12
            r12.d()
        La8:
            return r11
        La9:
            if (r0 == 0) goto Lb1
            r12 = r11
            androidx.emoji2.text.o r12 = (androidx.emoji2.text.o) r12
            r12.d()
        Lb1:
            return r11
        Lb2:
            if (r0 == 0) goto Lb9
            androidx.emoji2.text.o r11 = (androidx.emoji2.text.o) r11
            r11.d()
        Lb9:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.h.h(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }
}
