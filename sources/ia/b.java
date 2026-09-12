package ia;

import android.text.TextUtils;
import com.google.common.collect.ImmutableSet;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
final class b {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f65202d = Pattern.compile("\\s+");

    /* renamed from: e, reason: collision with root package name */
    private static final ImmutableSet f65203e = ImmutableSet.of("auto", "none");

    /* renamed from: f, reason: collision with root package name */
    private static final ImmutableSet f65204f = ImmutableSet.of("dot", "sesame", "circle");

    /* renamed from: g, reason: collision with root package name */
    private static final ImmutableSet f65205g = ImmutableSet.of("filled", MRAIDPresenter.OPEN);

    /* renamed from: h, reason: collision with root package name */
    private static final ImmutableSet f65206h = ImmutableSet.of("after", "before", "outside");

    /* renamed from: a, reason: collision with root package name */
    public final int f65207a;

    /* renamed from: b, reason: collision with root package name */
    public final int f65208b;

    /* renamed from: c, reason: collision with root package name */
    public final int f65209c;

    private b(int i11, int i12, int i13) {
        this.f65207a = i11;
        this.f65208b = i12;
        this.f65209c = i13;
    }

    public static b a(String str) {
        if (str == null) {
            return null;
        }
        String e11 = com.google.common.base.a.e(str.trim());
        if (e11.isEmpty()) {
            return null;
        }
        return b(ImmutableSet.copyOf(TextUtils.split(e11, f65202d)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ed, code lost:
    
        if (r9.equals("dot") != false) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static ia.b b(com.google.common.collect.ImmutableSet r9) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ia.b.b(com.google.common.collect.ImmutableSet):ia.b");
    }
}
