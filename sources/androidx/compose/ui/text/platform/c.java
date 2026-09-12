package androidx.compose.ui.text.platform;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.compose.ui.text.d0;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.u;
import androidx.compose.ui.text.w;
import androidx.emoji2.text.EmojiCompat;
import java.util.List;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import o0.x;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final a f6395a = new a();

    /* loaded from: classes.dex */
    public static final class a extends CharacterStyle {
        a() {
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [androidx.emoji2.text.EmojiCompat] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v3 */
    public static final CharSequence a(String str, float f11, d0 d0Var, List list, List list2, o0.e eVar, Function4 function4, boolean z10) {
        CharSequence charSequence;
        u a11;
        if (z10 && EmojiCompat.i()) {
            w w11 = d0Var.w();
            androidx.compose.ui.text.e d11 = (w11 == null || (a11 = w11.a()) == null) ? null : androidx.compose.ui.text.e.d(a11.a());
            charSequence = EmojiCompat.c().s(str, 0, str.length(), Integer.MAX_VALUE, d11 == null ? 0 : androidx.compose.ui.text.e.g(d11.j(), androidx.compose.ui.text.e.f6167b.a()));
            Intrinsics.e(charSequence);
        } else {
            charSequence = str;
        }
        if (list.isEmpty() && list2.isEmpty() && Intrinsics.c(d0Var.D(), androidx.compose.ui.text.style.n.f6504c.a()) && x.d(d0Var.s())) {
            return charSequence;
        }
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        if (Intrinsics.c(d0Var.A(), androidx.compose.ui.text.style.i.f6484b.d())) {
            SpannableExtensions_androidKt.u(spannableString, f6395a, 0, str.length());
        }
        if (b(d0Var) && d0Var.t() == null) {
            SpannableExtensions_androidKt.r(spannableString, d0Var.s(), f11, eVar);
        } else {
            androidx.compose.ui.text.style.g t11 = d0Var.t();
            if (t11 == null) {
                t11 = androidx.compose.ui.text.style.g.f6461c.a();
            }
            SpannableExtensions_androidKt.q(spannableString, d0Var.s(), f11, eVar, t11);
        }
        SpannableExtensions_androidKt.y(spannableString, d0Var.D(), f11, eVar);
        SpannableExtensions_androidKt.w(spannableString, d0Var, list, eVar, function4);
        androidx.compose.ui.text.platform.extensions.e.b(spannableString, list2, eVar);
        return spannableString;
    }

    public static final boolean b(d0 d0Var) {
        u a11;
        w w11 = d0Var.w();
        if (w11 == null || (a11 = w11.a()) == null) {
            return false;
        }
        return a11.b();
    }
}
