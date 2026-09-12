package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.a3;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.d0;
import androidx.compose.ui.text.font.e0;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k0.g0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class AndroidParagraphIntrinsics implements androidx.compose.ui.text.o {

    /* renamed from: a, reason: collision with root package name */
    private final String f6375a;

    /* renamed from: b, reason: collision with root package name */
    private final d0 f6376b;

    /* renamed from: c, reason: collision with root package name */
    private final List f6377c;

    /* renamed from: d, reason: collision with root package name */
    private final List f6378d;

    /* renamed from: e, reason: collision with root package name */
    private final h.b f6379e;

    /* renamed from: f, reason: collision with root package name */
    private final o0.e f6380f;

    /* renamed from: g, reason: collision with root package name */
    private final AndroidTextPaint f6381g;

    /* renamed from: h, reason: collision with root package name */
    private final CharSequence f6382h;

    /* renamed from: i, reason: collision with root package name */
    private final g0 f6383i;

    /* renamed from: j, reason: collision with root package name */
    private q f6384j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f6385k;

    /* renamed from: l, reason: collision with root package name */
    private final int f6386l;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.util.ArrayList] */
    public AndroidParagraphIntrinsics(String str, d0 d0Var, List list, List list2, h.b bVar, o0.e eVar) {
        boolean c11;
        this.f6375a = str;
        this.f6376b = d0Var;
        this.f6377c = list;
        this.f6378d = list2;
        this.f6379e = bVar;
        this.f6380f = eVar;
        AndroidTextPaint androidTextPaint = new AndroidTextPaint(1, eVar.getDensity());
        this.f6381g = androidTextPaint;
        c11 = d.c(d0Var);
        this.f6385k = !c11 ? false : ((Boolean) k.f6403a.a().getValue()).booleanValue();
        this.f6386l = d.d(d0Var.B(), d0Var.u());
        Function4<androidx.compose.ui.text.font.h, androidx.compose.ui.text.font.p, androidx.compose.ui.text.font.n, androidx.compose.ui.text.font.o, Typeface> function4 = new Function4<androidx.compose.ui.text.font.h, androidx.compose.ui.text.font.p, androidx.compose.ui.text.font.n, androidx.compose.ui.text.font.o, Typeface>() { // from class: androidx.compose.ui.text.platform.AndroidParagraphIntrinsics$resolveTypeface$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return m179invokeDPcqOEQ((androidx.compose.ui.text.font.h) obj, (androidx.compose.ui.text.font.p) obj2, ((androidx.compose.ui.text.font.n) obj3).i(), ((androidx.compose.ui.text.font.o) obj4).k());
            }

            /* renamed from: invoke-DPcqOEQ, reason: not valid java name */
            public final Typeface m179invokeDPcqOEQ(androidx.compose.ui.text.font.h hVar, androidx.compose.ui.text.font.p pVar, int i11, int i12) {
                q qVar;
                a3 a11 = AndroidParagraphIntrinsics.this.g().a(hVar, pVar, i11, i12);
                if (a11 instanceof e0.a) {
                    Object value = a11.getValue();
                    Intrinsics.f(value, "null cannot be cast to non-null type android.graphics.Typeface");
                    return (Typeface) value;
                }
                qVar = AndroidParagraphIntrinsics.this.f6384j;
                q qVar2 = new q(a11, qVar);
                AndroidParagraphIntrinsics.this.f6384j = qVar2;
                return qVar2.a();
            }
        };
        androidx.compose.ui.text.platform.extensions.f.e(androidTextPaint, d0Var.E());
        x a11 = androidx.compose.ui.text.platform.extensions.f.a(androidTextPaint, d0Var.L(), function4, eVar, !((Collection) list).isEmpty());
        if (a11 != null) {
            int size = list.size() + 1;
            list = new ArrayList(size);
            int i11 = 0;
            while (i11 < size) {
                list.add(i11 == 0 ? new AnnotatedString.c(a11, 0, this.f6375a.length()) : (AnnotatedString.c) this.f6377c.get(i11 - 1));
                i11++;
            }
        }
        CharSequence a12 = c.a(this.f6375a, this.f6381g.getTextSize(), this.f6376b, list, this.f6378d, this.f6380f, function4, this.f6385k);
        this.f6382h = a12;
        this.f6383i = new g0(a12, this.f6381g, this.f6386l);
    }

    @Override // androidx.compose.ui.text.o
    public float a() {
        return this.f6383i.b();
    }

    @Override // androidx.compose.ui.text.o
    public boolean b() {
        boolean c11;
        q qVar = this.f6384j;
        if (!(qVar != null ? qVar.b() : false)) {
            if (this.f6385k) {
                return false;
            }
            c11 = d.c(this.f6376b);
            if (!c11 || !((Boolean) k.f6403a.a().getValue()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.compose.ui.text.o
    public float c() {
        return this.f6383i.c();
    }

    public final CharSequence f() {
        return this.f6382h;
    }

    public final h.b g() {
        return this.f6379e;
    }

    public final g0 h() {
        return this.f6383i;
    }

    public final d0 i() {
        return this.f6376b;
    }

    public final int j() {
        return this.f6386l;
    }

    public final AndroidTextPaint k() {
        return this.f6381g;
    }
}
