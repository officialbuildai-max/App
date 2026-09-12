package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
public class StringsKt__StringsKt extends s {
    public static String A0(String str, int i11, char c11) {
        Intrinsics.h(str, "<this>");
        return z0(str, i11, c11).toString();
    }

    private static final Sequence B0(CharSequence charSequence, final char[] cArr, int i11, final boolean z10, int i12) {
        N0(i12);
        return new DelimitedRangesSequence(charSequence, i11, i12, new Function2() { // from class: kotlin.text.t
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Pair F0;
                F0 = StringsKt__StringsKt.F0(cArr, z10, (CharSequence) obj, ((Integer) obj2).intValue());
                return F0;
            }
        });
    }

    private static final Sequence C0(CharSequence charSequence, String[] strArr, int i11, final boolean z10, int i12) {
        N0(i12);
        final List i13 = ArraysKt.i(strArr);
        return new DelimitedRangesSequence(charSequence, i11, i12, new Function2() { // from class: kotlin.text.u
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Pair G0;
                G0 = StringsKt__StringsKt.G0(i13, z10, (CharSequence) obj, ((Integer) obj2).intValue());
                return G0;
            }
        });
    }

    static /* synthetic */ Sequence D0(CharSequence charSequence, char[] cArr, int i11, boolean z10, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            z10 = false;
        }
        if ((i13 & 8) != 0) {
            i12 = 0;
        }
        return B0(charSequence, cArr, i11, z10, i12);
    }

    static /* synthetic */ Sequence E0(CharSequence charSequence, String[] strArr, int i11, boolean z10, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            z10 = false;
        }
        if ((i13 & 8) != 0) {
            i12 = 0;
        }
        return C0(charSequence, strArr, i11, z10, i12);
    }

    public static final Pair F0(char[] cArr, boolean z10, CharSequence DelimitedRangesSequence, int i11) {
        Intrinsics.h(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        int p02 = p0(DelimitedRangesSequence, cArr, i11, z10);
        if (p02 < 0) {
            return null;
        }
        return TuplesKt.a(Integer.valueOf(p02), 1);
    }

    public static final Pair G0(List list, boolean z10, CharSequence DelimitedRangesSequence, int i11) {
        Intrinsics.h(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        Pair h02 = h0(DelimitedRangesSequence, list, i11, z10, false);
        if (h02 != null) {
            return TuplesKt.a(h02.getFirst(), Integer.valueOf(((String) h02.getSecond()).length()));
        }
        return null;
    }

    public static final boolean H0(CharSequence charSequence, int i11, CharSequence other, int i12, int i13, boolean z10) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(other, "other");
        if (i12 < 0 || i11 < 0 || i11 > charSequence.length() - i13 || i12 > other.length() - i13) {
            return false;
        }
        for (int i14 = 0; i14 < i13; i14++) {
            if (!c.g(charSequence.charAt(i11 + i14), other.charAt(i12 + i14), z10)) {
                return false;
            }
        }
        return true;
    }

    public static String I0(String str, CharSequence prefix) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(prefix, "prefix");
        if (!W0(str, prefix, false, 2, null)) {
            return str;
        }
        String substring = str.substring(prefix.length());
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static String J0(String str, CharSequence suffix) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(suffix, "suffix");
        if (!StringsKt.g0(str, suffix, false, 2, null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - suffix.length());
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static String K0(String str, CharSequence delimiter) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(delimiter, "delimiter");
        return L0(str, delimiter, delimiter);
    }

    public static final String L0(String str, CharSequence prefix, CharSequence suffix) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(prefix, "prefix");
        Intrinsics.h(suffix, "suffix");
        if (str.length() < prefix.length() + suffix.length() || !W0(str, prefix, false, 2, null) || !StringsKt.g0(str, suffix, false, 2, null)) {
            return str;
        }
        String substring = str.substring(prefix.length(), str.length() - suffix.length());
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static CharSequence M0(CharSequence charSequence, int i11, int i12, CharSequence replacement) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(replacement, "replacement");
        if (i12 >= i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(charSequence, 0, i11);
            Intrinsics.g(sb2, "append(...)");
            sb2.append(replacement);
            sb2.append(charSequence, i12, charSequence.length());
            Intrinsics.g(sb2, "append(...)");
            return sb2;
        }
        throw new IndexOutOfBoundsException("End index (" + i12 + ") is less than start index (" + i11 + ").");
    }

    public static final void N0(int i11) {
        if (i11 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i11).toString());
    }

    public static final List O0(CharSequence charSequence, char[] delimiters, boolean z10, int i11) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return Q0(charSequence, String.valueOf(delimiters[0]), z10, i11);
        }
        Iterable n11 = SequencesKt.n(D0(charSequence, delimiters, 0, z10, i11, 2, null));
        ArrayList arrayList = new ArrayList(CollectionsKt.v(n11, 10));
        Iterator it = n11.iterator();
        while (it.hasNext()) {
            arrayList.add(X0(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    public static final List P0(CharSequence charSequence, String[] delimiters, boolean z10, int i11) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return Q0(charSequence, str, z10, i11);
            }
        }
        Iterable n11 = SequencesKt.n(E0(charSequence, delimiters, 0, z10, i11, 2, null));
        ArrayList arrayList = new ArrayList(CollectionsKt.v(n11, 10));
        Iterator it = n11.iterator();
        while (it.hasNext()) {
            arrayList.add(X0(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    private static final List Q0(CharSequence charSequence, String str, boolean z10, int i11) {
        N0(i11);
        int i12 = 0;
        int k02 = StringsKt.k0(charSequence, str, 0, z10);
        if (k02 == -1 || i11 == 1) {
            return CollectionsKt.e(charSequence.toString());
        }
        boolean z11 = i11 > 0;
        ArrayList arrayList = new ArrayList(z11 ? RangesKt.i(i11, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i12, k02).toString());
            i12 = str.length() + k02;
            if (z11 && arrayList.size() == i11 - 1) {
                break;
            }
            k02 = StringsKt.k0(charSequence, str, i12, z10);
        } while (k02 != -1);
        arrayList.add(charSequence.subSequence(i12, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List R0(CharSequence charSequence, char[] cArr, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z10 = false;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return O0(charSequence, cArr, z10, i11);
    }

    public static /* synthetic */ List S0(CharSequence charSequence, String[] strArr, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z10 = false;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return P0(charSequence, strArr, z10, i11);
    }

    public static final boolean T0(CharSequence charSequence, char c11, boolean z10) {
        Intrinsics.h(charSequence, "<this>");
        return charSequence.length() > 0 && c.g(charSequence.charAt(0), c11, z10);
    }

    public static final boolean U0(CharSequence charSequence, CharSequence prefix, boolean z10) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(prefix, "prefix");
        return (!z10 && (charSequence instanceof String) && (prefix instanceof String)) ? StringsKt.W((String) charSequence, (String) prefix, false, 2, null) : H0(charSequence, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean V0(CharSequence charSequence, char c11, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return T0(charSequence, c11, z10);
    }

    public static /* synthetic */ boolean W0(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return U0(charSequence, charSequence2, z10);
    }

    public static final String X0(CharSequence charSequence, IntRange range) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(range, "range");
        return charSequence.subSequence(range.q().intValue(), range.p().intValue() + 1).toString();
    }

    public static final String Y0(String str, char c11, String missingDelimiterValue) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(missingDelimiterValue, "missingDelimiterValue");
        int n02 = StringsKt.n0(str, c11, 0, false, 6, null);
        if (n02 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(n02 + 1, str.length());
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static final boolean Z(CharSequence charSequence, char c11, boolean z10) {
        Intrinsics.h(charSequence, "<this>");
        return StringsKt.n0(charSequence, c11, 0, z10, 2, null) >= 0;
    }

    public static String Z0(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(delimiter, "delimiter");
        Intrinsics.h(missingDelimiterValue, "missingDelimiterValue");
        int o02 = StringsKt.o0(str, delimiter, 0, false, 6, null);
        if (o02 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(o02 + delimiter.length(), str.length());
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static boolean a0(CharSequence charSequence, CharSequence other, boolean z10) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(other, "other");
        if (other instanceof String) {
            if (StringsKt.o0(charSequence, (String) other, 0, z10, 2, null) < 0) {
                return false;
            }
        } else if (m0(charSequence, other, 0, charSequence.length(), z10, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ String a1(String str, char c11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = str;
        }
        return Y0(str, c11, str2);
    }

    public static /* synthetic */ boolean b0(CharSequence charSequence, char c11, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return Z(charSequence, c11, z10);
    }

    public static /* synthetic */ String b1(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return StringsKt.Z0(str, str2, str3);
    }

    public static /* synthetic */ boolean c0(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return StringsKt.a0(charSequence, charSequence2, z10);
    }

    public static String c1(String str, char c11, String missingDelimiterValue) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(missingDelimiterValue, "missingDelimiterValue");
        int u02 = StringsKt.u0(str, c11, 0, false, 6, null);
        if (u02 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(u02 + 1, str.length());
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static final boolean d0(CharSequence charSequence, char c11, boolean z10) {
        Intrinsics.h(charSequence, "<this>");
        return charSequence.length() > 0 && c.g(charSequence.charAt(StringsKt.i0(charSequence)), c11, z10);
    }

    public static String d1(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(delimiter, "delimiter");
        Intrinsics.h(missingDelimiterValue, "missingDelimiterValue");
        int v02 = StringsKt.v0(str, delimiter, 0, false, 6, null);
        if (v02 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(v02 + delimiter.length(), str.length());
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static final boolean e0(CharSequence charSequence, CharSequence suffix, boolean z10) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(suffix, "suffix");
        return (!z10 && (charSequence instanceof String) && (suffix instanceof String)) ? StringsKt.G((String) charSequence, (String) suffix, false, 2, null) : H0(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z10);
    }

    public static /* synthetic */ String e1(String str, char c11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = str;
        }
        return StringsKt.c1(str, c11, str2);
    }

    public static /* synthetic */ boolean f0(CharSequence charSequence, char c11, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return d0(charSequence, c11, z10);
    }

    public static /* synthetic */ String f1(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return StringsKt.d1(str, str2, str3);
    }

    public static /* synthetic */ boolean g0(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return e0(charSequence, charSequence2, z10);
    }

    public static final String g1(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(delimiter, "delimiter");
        Intrinsics.h(missingDelimiterValue, "missingDelimiterValue");
        int o02 = StringsKt.o0(str, delimiter, 0, false, 6, null);
        if (o02 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, o02);
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    private static final Pair h0(CharSequence charSequence, Collection collection, int i11, boolean z10, boolean z11) {
        Object obj;
        Object obj2;
        if (!z10 && collection.size() == 1) {
            String str = (String) CollectionsKt.E0(collection);
            int o02 = !z11 ? StringsKt.o0(charSequence, str, i11, false, 4, null) : StringsKt.v0(charSequence, str, i11, false, 4, null);
            if (o02 < 0) {
                return null;
            }
            return TuplesKt.a(Integer.valueOf(o02), str);
        }
        IntProgression intRange = !z11 ? new IntRange(RangesKt.f(i11, 0), charSequence.length()) : RangesKt.p(RangesKt.i(i11, StringsKt.i0(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int step = intRange.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    Iterator it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (StringsKt.K(str2, 0, (String) charSequence, first, str2.length(), z10)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (first == last) {
                            break;
                        }
                        first += step;
                    } else {
                        return TuplesKt.a(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = intRange.getFirst();
            int last2 = intRange.getLast();
            int step2 = intRange.getStep();
            if ((step2 > 0 && first2 <= last2) || (step2 < 0 && last2 <= first2)) {
                while (true) {
                    Iterator it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (H0(str4, 0, charSequence, first2, str4.length(), z10)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += step2;
                    } else {
                        return TuplesKt.a(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ String h1(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return g1(str, str2, str3);
    }

    public static int i0(CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final String i1(String str, char c11, String missingDelimiterValue) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(missingDelimiterValue, "missingDelimiterValue");
        int u02 = StringsKt.u0(str, c11, 0, false, 6, null);
        if (u02 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, u02);
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static final int j0(CharSequence charSequence, char c11, int i11, boolean z10) {
        Intrinsics.h(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? p0(charSequence, new char[]{c11}, i11, z10) : ((String) charSequence).indexOf(c11, i11);
    }

    public static String j1(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(delimiter, "delimiter");
        Intrinsics.h(missingDelimiterValue, "missingDelimiterValue");
        int v02 = StringsKt.v0(str, delimiter, 0, false, 6, null);
        if (v02 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, v02);
        Intrinsics.g(substring, "substring(...)");
        return substring;
    }

    public static int k0(CharSequence charSequence, String string, int i11, boolean z10) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(string, "string");
        return (z10 || !(charSequence instanceof String)) ? m0(charSequence, string, i11, charSequence.length(), z10, false, 16, null) : ((String) charSequence).indexOf(string, i11);
    }

    public static /* synthetic */ String k1(String str, char c11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = str;
        }
        return i1(str, c11, str2);
    }

    private static final int l0(CharSequence charSequence, CharSequence charSequence2, int i11, int i12, boolean z10, boolean z11) {
        IntProgression intRange = !z11 ? new IntRange(RangesKt.f(i11, 0), RangesKt.i(i12, charSequence.length())) : RangesKt.p(RangesKt.i(i11, StringsKt.i0(charSequence)), RangesKt.f(i12, 0));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int step = intRange.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return -1;
            }
            while (!H0(charSequence2, 0, charSequence, first, charSequence2.length(), z10)) {
                if (first == last) {
                    return -1;
                }
                first += step;
            }
            return first;
        }
        int first2 = intRange.getFirst();
        int last2 = intRange.getLast();
        int step2 = intRange.getStep();
        if ((step2 <= 0 || first2 > last2) && (step2 >= 0 || last2 > first2)) {
            return -1;
        }
        while (true) {
            String str = (String) charSequence2;
            if (StringsKt.K(str, 0, (String) charSequence, first2, str.length(), z10)) {
                return first2;
            }
            if (first2 == last2) {
                return -1;
            }
            first2 += step2;
        }
    }

    public static /* synthetic */ String l1(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return StringsKt.j1(str, str2, str3);
    }

    static /* synthetic */ int m0(CharSequence charSequence, CharSequence charSequence2, int i11, int i12, boolean z10, boolean z11, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            z11 = false;
        }
        return l0(charSequence, charSequence2, i11, i12, z10, z11);
    }

    public static Boolean m1(String str) {
        Intrinsics.h(str, "<this>");
        if (Intrinsics.c(str, "true")) {
            return Boolean.TRUE;
        }
        if (Intrinsics.c(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static /* synthetic */ int n0(CharSequence charSequence, char c11, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return j0(charSequence, c11, i11, z10);
    }

    public static CharSequence n1(CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i11 = 0;
        boolean z10 = false;
        while (i11 <= length) {
            boolean c11 = CharsKt.c(charSequence.charAt(!z10 ? i11 : length));
            if (z10) {
                if (!c11) {
                    break;
                }
                length--;
            } else if (c11) {
                i11++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i11, length + 1);
    }

    public static /* synthetic */ int o0(CharSequence charSequence, String str, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return StringsKt.k0(charSequence, str, i11, z10);
    }

    public static CharSequence o1(CharSequence charSequence, char... chars) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(chars, "chars");
        int length = charSequence.length() - 1;
        int i11 = 0;
        boolean z10 = false;
        while (i11 <= length) {
            boolean L = ArraysKt.L(chars, charSequence.charAt(!z10 ? i11 : length));
            if (z10) {
                if (!L) {
                    break;
                }
                length--;
            } else if (L) {
                i11++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i11, length + 1);
    }

    public static final int p0(CharSequence charSequence, char[] chars, int i11, boolean z10) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt.z0(chars), i11);
        }
        int f11 = RangesKt.f(i11, 0);
        int i02 = StringsKt.i0(charSequence);
        if (f11 > i02) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(f11);
            for (char c11 : chars) {
                if (c.g(c11, charAt, z10)) {
                    return f11;
                }
            }
            if (f11 == i02) {
                return -1;
            }
            f11++;
        }
    }

    public static String p1(String str, char... chars) {
        Intrinsics.h(str, "<this>");
        Intrinsics.h(chars, "chars");
        int length = str.length() - 1;
        int i11 = 0;
        boolean z10 = false;
        while (i11 <= length) {
            boolean L = ArraysKt.L(chars, str.charAt(!z10 ? i11 : length));
            if (z10) {
                if (!L) {
                    break;
                }
                length--;
            } else if (L) {
                i11++;
            } else {
                z10 = true;
            }
        }
        return str.subSequence(i11, length + 1).toString();
    }

    public static boolean q0(CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            if (!CharsKt.c(charSequence.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    public static CharSequence q1(CharSequence charSequence, char... chars) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(chars, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (!ArraysKt.L(chars, charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i11 < 0) {
                    break;
                }
                length = i11;
            }
        }
        return "";
    }

    public static final CharIterator r0(final CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        return new CharIterator() { // from class: kotlin.text.StringsKt__StringsKt$iterator$1

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private int index;

            @Override // kotlin.collections.CharIterator
            public char a() {
                CharSequence charSequence2 = charSequence;
                int i11 = this.index;
                this.index = i11 + 1;
                return charSequence2.charAt(i11);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < charSequence.length();
            }
        };
    }

    public static String r1(String str, char... chars) {
        CharSequence charSequence;
        Intrinsics.h(str, "<this>");
        Intrinsics.h(chars, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (!ArraysKt.L(chars, str.charAt(length))) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i11 < 0) {
                    break;
                }
                length = i11;
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    public static final int s0(CharSequence charSequence, char c11, int i11, boolean z10) {
        Intrinsics.h(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? w0(charSequence, new char[]{c11}, i11, z10) : ((String) charSequence).lastIndexOf(c11, i11);
    }

    public static CharSequence s1(CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!CharsKt.c(charSequence.charAt(i11))) {
                return charSequence.subSequence(i11, charSequence.length());
            }
        }
        return "";
    }

    public static final int t0(CharSequence charSequence, String string, int i11, boolean z10) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(string, "string");
        return (z10 || !(charSequence instanceof String)) ? l0(charSequence, string, i11, 0, z10, true) : ((String) charSequence).lastIndexOf(string, i11);
    }

    public static /* synthetic */ int u0(CharSequence charSequence, char c11, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = StringsKt.i0(charSequence);
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return s0(charSequence, c11, i11, z10);
    }

    public static /* synthetic */ int v0(CharSequence charSequence, String str, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = StringsKt.i0(charSequence);
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return t0(charSequence, str, i11, z10);
    }

    public static final int w0(CharSequence charSequence, char[] chars, int i11, boolean z10) {
        Intrinsics.h(charSequence, "<this>");
        Intrinsics.h(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt.z0(chars), i11);
        }
        for (int i12 = RangesKt.i(i11, StringsKt.i0(charSequence)); -1 < i12; i12--) {
            char charAt = charSequence.charAt(i12);
            for (char c11 : chars) {
                if (c.g(c11, charAt, z10)) {
                    return i12;
                }
            }
        }
        return -1;
    }

    public static Sequence x0(final CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        return new Sequence<String>() { // from class: kotlin.text.StringsKt__StringsKt$lineSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            /* renamed from: iterator */
            public Iterator getF67553a() {
                return new e(charSequence);
            }
        };
    }

    public static List y0(CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        return SequencesKt.D(StringsKt.x0(charSequence));
    }

    public static final CharSequence z0(CharSequence charSequence, int i11, char c11) {
        Intrinsics.h(charSequence, "<this>");
        if (i11 < 0) {
            throw new IllegalArgumentException("Desired length " + i11 + " is less than zero.");
        }
        if (i11 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(i11);
        int length = i11 - charSequence.length();
        int i12 = 1;
        if (1 <= length) {
            while (true) {
                sb2.append(c11);
                if (i12 == length) {
                    break;
                }
                i12++;
            }
        }
        sb2.append(charSequence);
        return sb2;
    }
}
