package rw;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0939a f74847a = new C0939a(null);

    /* renamed from: rw.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0939a {
        private C0939a() {
        }

        public /* synthetic */ C0939a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SpannableStringBuilder a(String prefix, String desc, int i11) {
            Intrinsics.h(prefix, "prefix");
            Intrinsics.h(desc, "desc");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(desc);
            int n02 = StringsKt.n0(desc, ':', 0, false, 6, null);
            if (n02 == -1) {
                return spannableStringBuilder;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i11), 0, n02, 33);
            return spannableStringBuilder;
        }
    }
}
