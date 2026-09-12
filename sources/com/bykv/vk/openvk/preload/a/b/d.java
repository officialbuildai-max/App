package com.bykv.vk.openvk.preload.a.b;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final int f20520a;

    static {
        String property = System.getProperty("java.version");
        int a11 = a(property);
        if (a11 == -1) {
            a11 = b(property);
        }
        if (a11 == -1) {
            a11 = 6;
        }
        f20520a = a11;
    }

    public static int a() {
        return f20520a;
    }

    private static int a(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            return (parseInt != 1 || split.length <= 1) ? parseInt : Integer.parseInt(split[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static int b(String str) {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < str.length(); i11++) {
                char charAt = str.charAt(i11);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb2.append(charAt);
            }
            return Integer.parseInt(sb2.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean b() {
        return f20520a >= 9;
    }
}
