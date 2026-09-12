package com.google.ads;

import android.content.pm.Signature;
import android.os.Build;
import android.util.DisplayMetrics;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;

/* loaded from: classes7.dex */
public class AdScreen {

    /* renamed from: ̅, reason: not valid java name and contains not printable characters */
    private static final short[] f33 = {1678, 1665, 1675, 1693, 1664, 1670, 1675, 1729, 1676, 1664, 1665, 1691, 1674, 1665, 1691, 1729, 1695, 1666, 1729, 1727, 1678, 1676, 1668, 1678, 1672, 1674, 1727, 1678, 1693, 1692, 1674, 1693, 1459, 1442, 1457, 1456, 1446, 1427, 1442, 1440, 1448, 1442, 1444, 1446, 2534, 2538, 2537, 2537, 2528, 2534, 2545, 2502, 2528, 2551, 2545, 2540, 2531, 2540, 2534, 2532, 2545, 2528, 2550, 2516, 2538, 2512, 2526, 2519, 2512, 2519, 2526, 2557, 2524, 2509, 2520, 2512, 2517, 2506, 1713, 1707, 1701, 1708, 1699, 1718, 1719, 1712, 1703, 1713, 2935, 2939, 2936, 2936, 2929, 2935, 2912, 2903, 2929, 2918, 2912, 2941, 2930, 2941, 2935, 2933, 2912, 2929, 2919, 1764, 1754, 1760, 1774, 1767, 1768, 1789, 1788, 1787, 1772, 1786, 2731, 2746, 2729, 2728, 2750, 2699, 2746, 2744, 2736, 2746, 2748, 2750, 2859, 2855, 2852, 2852, 2861, 2859, 2876, 2827, 2861, 2874, 2876, 2849, 2862, 2849, 2859, 2857, 2876, 2861, 2875, 1942, 1960, 1938, 1948, 1941, 1946, 1935, 1934, 1929, 1950, 1928, 1467, 1465, 1448, 1437, 1420, 1431, 1423, 1461, 1467, 1458, 1469, 1448, 1449, 1454, 1465, 1455};

    /* renamed from: ̍, reason: not valid java name and contains not printable characters */
    public static int f34 = -86;

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public AdScreen() {
        /*
            r1 = this;
            r1.<init>()
        L3:
            r0 = 53888503(0x33645f7, float:5.356531E-37)
        L6:
            switch(r0) {
                case -293080843: goto L17;
                case 53888503: goto Ld;
                default: goto L9;
            }
        L9:
            com.google.ads.AdView.m779()
            goto L3
        Ld:
            m765()
            r0 = -293080843(0xffffffffee87f0f5, float:-2.1035888E28)
            com.google.ads.AdView.m779()
            goto L6
        L17:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdScreen.<init>():void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:111:0x02e4. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:119:0x02fc. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:164:0x04b6. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x00c8. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x00cf. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:47:0x0102. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:57:0x0159. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x005c. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:70:0x01b1. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:99:0x022b. Please report as an issue. */
    /* renamed from: ̎, reason: not valid java name and contains not printable characters */
    public static String m757(String str) {
        boolean z10;
        short[] sArr = f33;
        int m784 = AdView.m784((Object) "ۧۨۘ");
        int m7842 = AdView.m784((Object) "۬ۘۥ");
        int m7843 = AdView.m784((Object) "۫ۨۘ");
        try {
            Class<?> m785 = AdView.m785(AdView.m786(sArr, ((m7842 ^ (-1)) & 1758969) | ((-1758970) & m7842), ((m7843 ^ (-1)) & 1758523) | ((-1758524) & m7843), ((m784 ^ (-1)) & 1753336) | ((-1753337) & m784)));
            DisplayMetrics displayMetrics = new DisplayMetrics();
            m766(displayMetrics);
            boolean m775 = AdView.m775();
            while (true) {
                char c11 = 1627;
                AdView.m779();
                while (true) {
                    int i11 = (c11 & 32138) | ((c11 ^ 65535) & 98933);
                    while (true) {
                        switch (i11) {
                            case -415979768:
                                RewardAd.m796();
                                break;
                            case -374939829:
                                AdView.m779();
                                boolean m772 = AdView.m772(str);
                                while (true) {
                                    char c12 = 38612;
                                    while (true) {
                                        int i12 = (c12 & 2649) | ((c12 ^ 65535) & 62886);
                                        while (true) {
                                            switch (i12) {
                                                case -980352227:
                                                    while (true) {
                                                        char c13 = 42811;
                                                        while (true) {
                                                            switch (c13) {
                                                                case 42811:
                                                                    RewardAd.m796();
                                                                    c13 = 40475;
                                                                case 40475:
                                                                    break;
                                                            }
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case 53830514:
                                                    if (m772) {
                                                        i12 = -980352227;
                                                    }
                                                    break;
                                                case 426973340:
                                                    while (true) {
                                                        AdView.m779();
                                                        char c14 = 61631;
                                                        while (true) {
                                                            switch (c14) {
                                                                case 61631:
                                                                    AdView.m779();
                                                                    c14 = 25438;
                                                                    RewardAd.m796();
                                                                case 25438:
                                                                    int i13 = Build.VERSION.SDK_INT;
                                                                    AdView.m779();
                                                                    while (true) {
                                                                        char c15 = 40193;
                                                                        m765();
                                                                        while (true) {
                                                                            int i14 = (c15 & 39479) | ((c15 ^ 65535) & 91592);
                                                                            while (true) {
                                                                                switch (i14) {
                                                                                    case 53803209:
                                                                                        if (i13 > 20) {
                                                                                            m765();
                                                                                            i14 = 1745667287;
                                                                                            m765();
                                                                                        }
                                                                                        break;
                                                                                    case 1089886550:
                                                                                        RewardAd.m796();
                                                                                        Object m738 = AdActivity.m738(AdActivity.m749(m785, new Class[]{String.class}), new Object[]{str});
                                                                                        short[] sArr2 = f33;
                                                                                        int m7844 = AdView.m784((Object) "ۘۥۚ");
                                                                                        int m7845 = AdView.m784((Object) "ۨۧۧ");
                                                                                        int m7846 = AdView.m784((Object) "ۨۨۖ");
                                                                                        String m786 = AdView.m786(sArr2, ((m7845 ^ (-1)) & 1755582) | ((-1755583) & m7845), ((m7846 ^ (-1)) & 1755610) | ((-1755611) & m7846), ((m7844 ^ (-1)) & 1738678) | ((-1738679) & m7844));
                                                                                        while (true) {
                                                                                            m765();
                                                                                            char c16 = 32683;
                                                                                            while (true) {
                                                                                                switch (c16) {
                                                                                                    case 32683:
                                                                                                        c16 = 11772;
                                                                                                        AdView.m779();
                                                                                                    case 11772:
                                                                                                        Object m777 = AdView.m777(m759(m785, m786, new Class[]{File.class, String.class, DisplayMetrics.class, Integer.TYPE}), m738, new Object[]{new File(str), str, displayMetrics, AdActivity.m756(64)});
                                                                                                        short[] sArr3 = f33;
                                                                                                        int m7847 = AdView.m784((Object) "ۖۤ۫");
                                                                                                        int m7848 = AdView.m784((Object) "ۛ۟ۙ");
                                                                                                        int m7849 = AdView.m784((Object) "ۛ۟ۨ");
                                                                                                        String m7862 = AdView.m786(sArr3, ((m7848 ^ (-1)) & 1742711) | ((-1742712) & m7848), ((m7849 ^ (-1)) & 1742871) | ((-1742872) & m7849), ((m7847 ^ (-1)) & 1740437) | ((-1740438) & m7847));
                                                                                                        Class m781 = AdView.m781(m777);
                                                                                                        while (true) {
                                                                                                            char c17 = 57895;
                                                                                                            while (true) {
                                                                                                                switch (c17) {
                                                                                                                    case 57895:
                                                                                                                        AdView.m779();
                                                                                                                        c17 = 35536;
                                                                                                                    case 35536:
                                                                                                                        break;
                                                                                                                }
                                                                                                                AdView.m777(m759(m785, m7862, new Class[]{m781, Integer.TYPE}), m738, new Object[]{m777, AdActivity.m756(64)});
                                                                                                                Class m7812 = AdView.m781(m777);
                                                                                                                short[] sArr4 = f33;
                                                                                                                int m78410 = AdView.m784((Object) "۫ۜۤ");
                                                                                                                int m78411 = AdView.m784((Object) "ۗۗۥ");
                                                                                                                int m78412 = AdView.m784((Object) "ۚ۟۫");
                                                                                                                String m763 = m763(((Signature[]) AdView.m783(m768(m7812, AdView.m786(sArr4, ((m78411 ^ (-1)) & 1738896) | ((-1738897) & m78411), ((m78412 ^ (-1)) & 1741901) | ((-1741902) & m78412), ((m78410 ^ (-1)) & 1758280) | ((-1758281) & m78410))), m777))[0]);
                                                                                                                while (true) {
                                                                                                                    RewardAd.m796();
                                                                                                                    char c18 = 13096;
                                                                                                                    while (true) {
                                                                                                                        switch (c18) {
                                                                                                                            case 13096:
                                                                                                                                c18 = 21183;
                                                                                                                            case 21183:
                                                                                                                                return m763;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    m765();
                                                                                                                }
                                                                                                            }
                                                                                                            AdActivity.m731();
                                                                                                        }
                                                                                                        break;
                                                                                                }
                                                                                            }
                                                                                            AdActivity.m731();
                                                                                        }
                                                                                        break;
                                                                                    case 1745667287:
                                                                                        RewardAd.m796();
                                                                                        Object m7382 = AdActivity.m738(AdActivity.m749(m785, new Class[0]), new Object[0]);
                                                                                        short[] sArr5 = f33;
                                                                                        int m78413 = AdView.m784((Object) "۫۫ۛ");
                                                                                        int m78414 = AdView.m784((Object) "ۧۨۧ");
                                                                                        int m78415 = AdView.m784((Object) "ۛۢۥ");
                                                                                        String m7863 = AdView.m786(sArr5, ((m78414 ^ (-1)) & 1754630) | ((-1754631) & m78414), ((m78415 ^ (-1)) & 1742930) | ((-1742931) & m78415), ((m78413 ^ (-1)) & 1757368) | ((-1757369) & m78413));
                                                                                        while (true) {
                                                                                            m765();
                                                                                            char c19 = 18405;
                                                                                            while (true) {
                                                                                                switch (c19) {
                                                                                                    case 45872:
                                                                                                        break;
                                                                                                    case 18405:
                                                                                                        RewardAd.m796();
                                                                                                        c19 = 45872;
                                                                                                        RewardAd.m796();
                                                                                                }
                                                                                                Class cls = Integer.TYPE;
                                                                                                AdActivity.m731();
                                                                                                Object m7772 = AdView.m777(m759(m785, m7863, new Class[]{File.class, cls}), m7382, new Object[]{new File(str), AdActivity.m756(64)});
                                                                                                while (true) {
                                                                                                    char c20 = 56867;
                                                                                                    while (true) {
                                                                                                        switch (c20) {
                                                                                                            case 54358:
                                                                                                                int i15 = Build.VERSION.SDK_INT;
                                                                                                                while (true) {
                                                                                                                    char c21 = 2495;
                                                                                                                    AdView.m779();
                                                                                                                    while (true) {
                                                                                                                        int i16 = (c21 & 20995) | ((c21 ^ 65535) & 44540);
                                                                                                                        while (true) {
                                                                                                                            switch (i16) {
                                                                                                                                case -1344074391:
                                                                                                                                    AdView.m779();
                                                                                                                                    short[] sArr6 = f33;
                                                                                                                                    int m78416 = AdView.m784((Object) "ۥۛۦ");
                                                                                                                                    int m78417 = AdView.m784((Object) "ۛۚۙ");
                                                                                                                                    int m78418 = AdView.m784((Object) "ۚۦ۠");
                                                                                                                                    String m7864 = AdView.m786(sArr6, ((m78417 ^ (-1)) & 1742710) | ((-1742711) & m78417), ((m78418 ^ (-1)) & 1742087) | ((-1742088) & m78418), ((m78416 ^ (-1)) & 1750165) | ((-1750166) & m78416));
                                                                                                                                    Class m7813 = AdView.m781(m7772);
                                                                                                                                    while (true) {
                                                                                                                                        AdView.m779();
                                                                                                                                        char c22 = 51292;
                                                                                                                                        while (true) {
                                                                                                                                            switch (c22) {
                                                                                                                                                case 53244:
                                                                                                                                                    Class cls2 = Boolean.TYPE;
                                                                                                                                                    RewardAd.m796();
                                                                                                                                                    Method m759 = m759(m785, m7864, new Class[]{m7813, cls2});
                                                                                                                                                    while (true) {
                                                                                                                                                        char c23 = 23726;
                                                                                                                                                        while (true) {
                                                                                                                                                            switch (c23) {
                                                                                                                                                                case 16812:
                                                                                                                                                                    int i17 = Build.VERSION.SDK_INT;
                                                                                                                                                                    while (true) {
                                                                                                                                                                        char c24 = 2588;
                                                                                                                                                                        while (true) {
                                                                                                                                                                            int i18 = (c24 & 39932) | ((c24 ^ 65535) & 91139);
                                                                                                                                                                            while (true) {
                                                                                                                                                                                switch (i18) {
                                                                                                                                                                                    case -65238595:
                                                                                                                                                                                        m765();
                                                                                                                                                                                        z10 = false;
                                                                                                                                                                                        break;
                                                                                                                                                                                    case 53964319:
                                                                                                                                                                                        if (i17 > 28) {
                                                                                                                                                                                            RewardAd.m796();
                                                                                                                                                                                            i18 = 1842794044;
                                                                                                                                                                                            RewardAd.m796();
                                                                                                                                                                                        }
                                                                                                                                                                                        break;
                                                                                                                                                                                    case 1842794044:
                                                                                                                                                                                        while (true) {
                                                                                                                                                                                            AdActivity.m731();
                                                                                                                                                                                            char c25 = 11735;
                                                                                                                                                                                            while (true) {
                                                                                                                                                                                                switch (c25) {
                                                                                                                                                                                                    case 25087:
                                                                                                                                                                                                        break;
                                                                                                                                                                                                    case 11735:
                                                                                                                                                                                                        c25 = 25087;
                                                                                                                                                                                                        AdView.m779();
                                                                                                                                                                                                }
                                                                                                                                                                                                z10 = true;
                                                                                                                                                                                                break;
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                        break;
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                            c24 = 60862;
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                    AdView.m777(m759, m7382, new Object[]{m7772, AdActivity.m736(z10)});
                                                                                                                                                                    Class m7814 = AdView.m781(m7772);
                                                                                                                                                                    short[] sArr7 = f33;
                                                                                                                                                                    int m78419 = AdView.m784((Object) "ۧۤ۟");
                                                                                                                                                                    int m78420 = AdView.m784((Object) "ۥۡۗ");
                                                                                                                                                                    int m78421 = AdView.m784((Object) "ۗۛ۠");
                                                                                                                                                                    Field m768 = m768(m7814, AdView.m786(sArr7, ((m78420 ^ (-1)) & 1752452) | ((-1752453) & m78420), ((m78421 ^ (-1)) & 1738867) | ((-1738868) & m78421), ((m78419 ^ (-1)) & 1756187) | ((-1756188) & m78419)));
                                                                                                                                                                    m767(m768, true);
                                                                                                                                                                    Object m783 = AdView.m783(m768, m7772);
                                                                                                                                                                    Class m7815 = AdView.m781(m783);
                                                                                                                                                                    short[] sArr8 = f33;
                                                                                                                                                                    int m78422 = AdView.m784((Object) "۟ۥۜ");
                                                                                                                                                                    int m78423 = AdView.m784((Object) "ۡۨۖ");
                                                                                                                                                                    int m78424 = AdView.m784((Object) "ۗۜۚ");
                                                                                                                                                                    Field m7682 = m768(m7815, AdView.m786(sArr8, ((m78423 ^ (-1)) & 1748929) | ((-1748930) & m78423), ((m78424 ^ (-1)) & 1738911) | ((-1738912) & m78424), ((m78422 ^ (-1)) & 1745268) | ((-1745269) & m78422)));
                                                                                                                                                                    m767(m7682, true);
                                                                                                                                                                    String m7632 = m763(((Signature[]) AdView.m783(m7682, m783))[0]);
                                                                                                                                                                    while (true) {
                                                                                                                                                                        RewardAd.m796();
                                                                                                                                                                        char c26 = 8587;
                                                                                                                                                                        while (true) {
                                                                                                                                                                            switch (c26) {
                                                                                                                                                                                case 8587:
                                                                                                                                                                                    AdActivity.m731();
                                                                                                                                                                                    c26 = 2731;
                                                                                                                                                                                case 2731:
                                                                                                                                                                                    break;
                                                                                                                                                                            }
                                                                                                                                                                            return m7632;
                                                                                                                                                                        }
                                                                                                                                                                        AdActivity.m731();
                                                                                                                                                                    }
                                                                                                                                                                    break;
                                                                                                                                                                case 23726:
                                                                                                                                                                    AdView.m779();
                                                                                                                                                                    c23 = 16812;
                                                                                                                                                                    m765();
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    break;
                                                                                                                                                case 51292:
                                                                                                                                                    c22 = 53244;
                                                                                                                                                    AdActivity.m731();
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 53912643:
                                                                                                                                    if (i15 >= 28) {
                                                                                                                                        AdActivity.m731();
                                                                                                                                        i16 = -1344074391;
                                                                                                                                        AdActivity.m731();
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                                case 1278338664:
                                                                                                                                    short[] sArr9 = f33;
                                                                                                                                    int m78425 = AdView.m784((Object) "ۢۡ۠");
                                                                                                                                    int m78426 = AdView.m784((Object) "ۤۧۘ");
                                                                                                                                    int m78427 = AdView.m784((Object) "ۤۙ۠");
                                                                                                                                    String m7865 = AdView.m786(sArr9, ((m78426 ^ (-1)) & 1751789) | ((-1751790) & m78426), ((m78427 ^ (-1)) & 1751320) | ((-1751321) & m78427), ((m78425 ^ (-1)) & 1751445) | ((-1751446) & m78425));
                                                                                                                                    Class m7816 = AdView.m781(m7772);
                                                                                                                                    while (true) {
                                                                                                                                        RewardAd.m796();
                                                                                                                                        char c27 = 54344;
                                                                                                                                        while (true) {
                                                                                                                                            switch (c27) {
                                                                                                                                                case 54344:
                                                                                                                                                    AdView.m779();
                                                                                                                                                    c27 = 8491;
                                                                                                                                                    RewardAd.m796();
                                                                                                                                                case 8491:
                                                                                                                                                    AdView.m777(m759(m785, m7865, new Class[]{m7816, Integer.TYPE}), m7382, new Object[]{m7772, AdActivity.m756(64)});
                                                                                                                                                    Class m7817 = AdView.m781(m7772);
                                                                                                                                                    short[] sArr10 = f33;
                                                                                                                                                    int m78428 = AdView.m784((Object) "ۨۦۢ");
                                                                                                                                                    int m78429 = AdView.m784((Object) "۟ۨۖ");
                                                                                                                                                    int m78430 = AdView.m784((Object) "ۚۛۘ");
                                                                                                                                                    String m7633 = m763(((Signature[]) AdView.m783(m768(m7817, AdView.m786(sArr10, ((m78429 ^ (-1)) & 1747046) | ((-1747047) & m78429), ((m78430 ^ (-1)) & 1741756) | ((-1741757) & m78430), ((m78428 ^ (-1)) & 1756973) | ((-1756974) & m78428))), m7772))[0]);
                                                                                                                                                    while (true) {
                                                                                                                                                        AdView.m779();
                                                                                                                                                        char c28 = 54619;
                                                                                                                                                        while (true) {
                                                                                                                                                            switch (c28) {
                                                                                                                                                                case 27064:
                                                                                                                                                                    return m7633;
                                                                                                                                                                case 54619:
                                                                                                                                                                    c28 = 27064;
                                                                                                                                                                    RewardAd.m796();
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        m765();
                                                                                                                                    }
                                                                                                                                    break;
                                                                                                                            }
                                                                                                                        }
                                                                                                                        c21 = 19348;
                                                                                                                        AdActivity.m731();
                                                                                                                    }
                                                                                                                    AdView.m779();
                                                                                                                }
                                                                                                                break;
                                                                                                            case 56867:
                                                                                                                c20 = 54358;
                                                                                                                AdActivity.m731();
                                                                                                        }
                                                                                                    }
                                                                                                    AdActivity.m731();
                                                                                                }
                                                                                            }
                                                                                            RewardAd.m796();
                                                                                        }
                                                                                        break;
                                                                                }
                                                                            }
                                                                            c15 = 15518;
                                                                            m765();
                                                                        }
                                                                        m765();
                                                                    }
                                                                    break;
                                                            }
                                                        }
                                                        AdActivity.m731();
                                                    }
                                                    break;
                                            }
                                        }
                                        c12 = 60730;
                                    }
                                }
                                break;
                            case 53969966:
                                if (!m775) {
                                    AdActivity.m731();
                                    i11 = -374939829;
                                    AdView.m779();
                                }
                                break;
                        }
                    }
                    c11 = 9597;
                    RewardAd.m796();
                }
                m765();
            }
            while (true) {
                AdActivity.m731();
                char c29 = 10429;
                while (true) {
                    switch (c29) {
                        case 21789:
                            return null;
                        case 10429:
                            RewardAd.m796();
                            c29 = 21789;
                    }
                }
                AdView.m779();
            }
        } catch (Exception e11) {
            short[] sArr11 = f33;
            int m78431 = AdView.m784((Object) "ۤ۠ۖ");
            int m78432 = AdView.m784((Object) "۬ۚۘ");
            int m78433 = AdView.m784((Object) "ۢۡۧ");
            loadAd.m814(AdView.m786(sArr11, ((m78432 ^ (-1)) & 1759114) | ((-1759115) & m78432), ((m78433 ^ (-1)) & 1749656) | ((-1749657) & m78433), ((m78431 ^ (-1)) & 1752070) | ((-1752071) & m78431)), m771(e11));
            loadAd.m822(e11);
            while (true) {
                m765();
                char c30 = 45327;
                while (true) {
                    switch (c30) {
                        case 51825:
                            return null;
                        case 45327:
                            c30 = 51825;
                    }
                }
            }
        }
    }

    /* renamed from: ̐, reason: not valid java name and contains not printable characters */
    public static String m758(Object obj, int i11) {
        return ((String) obj).substring(i11);
    }

    /* renamed from: ̒, reason: not valid java name and contains not printable characters */
    public static Method m759(Object obj, Object obj2, Object obj3) {
        return ((Class) obj).getDeclaredMethod((String) obj2, (Class[]) obj3);
    }

    /* renamed from: ̓, reason: not valid java name and contains not printable characters */
    public static char[] m760(Object obj) {
        return ((String) obj).toCharArray();
    }

    /* renamed from: ̔, reason: not valid java name and contains not printable characters */
    public static int m761(Object obj, Object obj2) {
        return RewardAd.m793((String) obj, (String) obj2);
    }

    /* renamed from: ̕, reason: not valid java name and contains not printable characters */
    public static boolean m762(Object obj) {
        return ((File) obj).exists();
    }

    /* renamed from: ̖, reason: not valid java name and contains not printable characters */
    public static String m763(Object obj) {
        return ((Signature) obj).toCharsString();
    }

    /* renamed from: ̗, reason: not valid java name and contains not printable characters */
    public static byte[] m764(Object obj) {
        return ((MessageDigest) obj).digest();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* renamed from: ̘, reason: not valid java name and contains not printable characters */
    public static boolean m765() {
        /*
        L0:
            r0 = 53972147(0x3378cb3, float:5.394038E-37)
        L3:
            switch(r0) {
                case 53972147: goto L7;
                case 2019490863: goto Lb;
                default: goto L6;
            }
        L6:
            goto L0
        L7:
            r0 = 2019490863(0x785efc2f, float:1.80907E34)
            goto L3
        Lb:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdScreen.m765():boolean");
    }

    /* renamed from: ̙, reason: not valid java name and contains not printable characters */
    public static void m766(Object obj) {
        ((DisplayMetrics) obj).setToDefaults();
    }

    /* renamed from: ̚, reason: not valid java name and contains not printable characters */
    public static void m767(Object obj, boolean z10) {
        ((Field) obj).setAccessible(z10);
    }

    /* renamed from: ̜, reason: not valid java name and contains not printable characters */
    public static Field m768(Object obj, Object obj2) {
        return ((Class) obj).getDeclaredField((String) obj2);
    }

    /* renamed from: ̝, reason: not valid java name and contains not printable characters */
    public static Class m769(Object obj) {
        return Class.forName((String) obj);
    }

    /* renamed from: ̞, reason: not valid java name and contains not printable characters */
    public static File[] m770(Object obj) {
        return ((File) obj).listFiles();
    }

    /* renamed from: ̟, reason: not valid java name and contains not printable characters */
    public static String m771(Object obj) {
        return ((Exception) obj).getMessage();
    }
}
