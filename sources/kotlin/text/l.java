package kotlin.text;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends h {
    private static final Function1 e(final String str) {
        return str.length() == 0 ? new Function1() { // from class: kotlin.text.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String f11;
                f11 = l.f((String) obj);
                return f11;
            }
        } : new Function1() { // from class: kotlin.text.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String g11;
                g11 = l.g(str, (String) obj);
                return g11;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(String line) {
        Intrinsics.h(line, "line");
        return line;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(String str, String line) {
        Intrinsics.h(line, "line");
        return str + line;
    }

    private static final int h(String str) {
        int length = str.length();
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            }
            if (!CharsKt.c(str.charAt(i11))) {
                break;
            }
            i11++;
        }
        return i11 == -1 ? str.length() : i11;
    }

    public static final String i(String str, final String indent) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(indent, "indent");
        return SequencesKt.w(SequencesKt.y(StringsKt.x0(str), new Function1() { // from class: kotlin.text.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String k11;
                k11 = l.k(indent, (String) obj);
                return k11;
            }
        }), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String j(String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str2 = "    ";
        }
        return i(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String k(String str, String it) {
        Intrinsics.h(it, "it");
        if (StringsKt.q0(it)) {
            return it.length() < str.length() ? str : it;
        }
        return str + it;
    }

    public static final String l(String str, String newIndent) {
        String str2;
        Intrinsics.h(str, "<this>");
        Intrinsics.h(newIndent, "newIndent");
        List y02 = StringsKt.y0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : y02) {
            if (!StringsKt.q0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(h((String) it.next())));
        }
        Integer num = (Integer) CollectionsKt.y0(arrayList2);
        int i11 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * y02.size());
        Function1 e11 = e(newIndent);
        int n11 = CollectionsKt.n(y02);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : y02) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            String str3 = (String) obj2;
            if ((i11 == 0 || i11 == n11) && StringsKt.q0(str3)) {
                str3 = null;
            } else {
                String t12 = StringsKt.t1(str3, intValue);
                if (t12 != null && (str2 = (String) e11.invoke(t12)) != null) {
                    str3 = str2;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i11 = i12;
        }
        return ((StringBuilder) CollectionsKt.q0(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, null)).toString();
    }

    public static final String m(String str, String newIndent, String marginPrefix) {
        int i11;
        String str2;
        Intrinsics.h(str, "<this>");
        Intrinsics.h(newIndent, "newIndent");
        Intrinsics.h(marginPrefix, "marginPrefix");
        if (StringsKt.q0(marginPrefix)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List y02 = StringsKt.y0(str);
        int length = str.length() + (newIndent.length() * y02.size());
        Function1 e11 = e(newIndent);
        int n11 = CollectionsKt.n(y02);
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        for (Object obj : y02) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt.u();
            }
            String str3 = (String) obj;
            String str4 = null;
            if ((i12 == 0 || i12 == n11) && StringsKt.q0(str3)) {
                str3 = null;
            } else {
                int length2 = str3.length();
                int i14 = 0;
                while (true) {
                    if (i14 >= length2) {
                        i11 = -1;
                        break;
                    }
                    if (!CharsKt.c(str3.charAt(i14))) {
                        i11 = i14;
                        break;
                    }
                    i14++;
                }
                if (i11 != -1) {
                    int i15 = i11;
                    if (StringsKt.V(str3, marginPrefix, i11, false, 4, null)) {
                        int length3 = i15 + marginPrefix.length();
                        Intrinsics.f(str3, "null cannot be cast to non-null type java.lang.String");
                        str4 = str3.substring(length3);
                        Intrinsics.g(str4, "substring(...)");
                    }
                }
                if (str4 != null && (str2 = (String) e11.invoke(str4)) != null) {
                    str3 = str2;
                }
            }
            if (str3 != null) {
                arrayList.add(str3);
            }
            i12 = i13;
        }
        return ((StringBuilder) CollectionsKt.q0(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, Sdk$SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, null)).toString();
    }

    public static String n(String str) {
        Intrinsics.h(str, "<this>");
        return l(str, "");
    }

    public static final String o(String str, String marginPrefix) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(marginPrefix, "marginPrefix");
        return m(str, "", marginPrefix);
    }

    public static /* synthetic */ String p(String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str2 = "|";
        }
        return o(str, str2);
    }
}
