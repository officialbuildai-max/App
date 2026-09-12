package com.alibaba.fastjson;

/* loaded from: classes2.dex */
public enum PropertyNamingStrategy {
    CamelCase,
    PascalCase,
    SnakeCase,
    KebabCase,
    NoChange,
    NeverUseThisValueExceptDefaultValue;

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f18146a;

        static {
            int[] iArr = new int[PropertyNamingStrategy.values().length];
            f18146a = iArr;
            try {
                iArr[PropertyNamingStrategy.SnakeCase.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18146a[PropertyNamingStrategy.KebabCase.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18146a[PropertyNamingStrategy.PascalCase.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18146a[PropertyNamingStrategy.CamelCase.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18146a[PropertyNamingStrategy.NoChange.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18146a[PropertyNamingStrategy.NeverUseThisValueExceptDefaultValue.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String translate(String str) {
        char charAt;
        int i11 = a.f18146a[ordinal()];
        int i12 = 0;
        if (i11 == 1) {
            StringBuilder sb2 = new StringBuilder();
            while (i12 < str.length()) {
                char charAt2 = str.charAt(i12);
                if (charAt2 < 'A' || charAt2 > 'Z') {
                    sb2.append(charAt2);
                } else {
                    char c11 = (char) (charAt2 + ' ');
                    if (i12 > 0) {
                        sb2.append('_');
                    }
                    sb2.append(c11);
                }
                i12++;
            }
            return sb2.toString();
        }
        if (i11 == 2) {
            StringBuilder sb3 = new StringBuilder();
            while (i12 < str.length()) {
                char charAt3 = str.charAt(i12);
                if (charAt3 < 'A' || charAt3 > 'Z') {
                    sb3.append(charAt3);
                } else {
                    char c12 = (char) (charAt3 + ' ');
                    if (i12 > 0) {
                        sb3.append('-');
                    }
                    sb3.append(c12);
                }
                i12++;
            }
            return sb3.toString();
        }
        if (i11 != 3) {
            if (i11 != 4 || (charAt = str.charAt(0)) < 'A' || charAt > 'Z') {
                return str;
            }
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] + ' ');
            return new String(charArray);
        }
        char charAt4 = str.charAt(0);
        if (charAt4 < 'a' || charAt4 > 'z') {
            return str;
        }
        char[] charArray2 = str.toCharArray();
        charArray2[0] = (char) (charArray2[0] - ' ');
        return new String(charArray2);
    }
}
