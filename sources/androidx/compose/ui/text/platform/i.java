package androidx.compose.ui.text.platform;

import androidx.compose.runtime.a3;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.emoji2.text.EmojiCompat;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
final class i implements l {

    /* renamed from: a, reason: collision with root package name */
    private a3 f6399a;

    /* loaded from: classes.dex */
    public static final class a extends EmojiCompat.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i1 f6400a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f6401b;

        a(i1 i1Var, i iVar) {
            this.f6400a = i1Var;
            this.f6401b = iVar;
        }

        @Override // androidx.emoji2.text.EmojiCompat.f
        public void a(Throwable th2) {
            n nVar;
            i iVar = this.f6401b;
            nVar = m.f6406a;
            iVar.f6399a = nVar;
        }

        @Override // androidx.emoji2.text.EmojiCompat.f
        public void b() {
            this.f6400a.setValue(Boolean.TRUE);
            this.f6401b.f6399a = new n(true);
        }
    }

    public i() {
        this.f6399a = EmojiCompat.i() ? c() : null;
    }

    private final a3 c() {
        i1 c11;
        EmojiCompat c12 = EmojiCompat.c();
        if (c12.e() == 1) {
            return new n(true);
        }
        c11 = u2.c(Boolean.FALSE, null, 2, null);
        c12.t(new a(c11, this));
        return c11;
    }

    @Override // androidx.compose.ui.text.platform.l
    public a3 a() {
        n nVar;
        a3 a3Var = this.f6399a;
        if (a3Var != null) {
            Intrinsics.e(a3Var);
            return a3Var;
        }
        if (!EmojiCompat.i()) {
            nVar = m.f6406a;
            return nVar;
        }
        a3 c11 = c();
        this.f6399a = c11;
        Intrinsics.e(c11);
        return c11;
    }
}
