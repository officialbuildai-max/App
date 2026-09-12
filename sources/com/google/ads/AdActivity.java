package com.google.ads;

import android.content.Context;
import android.util.Base64;
import java.security.MessageDigest;

/* loaded from: classes7.dex */
public class AdActivity {

    /* renamed from: ̅, reason: not valid java name and contains not printable characters */
    public static boolean f31 = false;

    /* renamed from: ̍, reason: not valid java name and contains not printable characters */
    public static int f32 = -80;

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
    public AdActivity() {
        /*
            r1 = this;
            r1.<init>()
        L3:
            com.google.ads.NativeAd.m788()
            r0 = 1783077(0x1b3525, float:2.498623E-39)
        L9:
            switch(r0) {
                case -1060790147: goto Ld;
                case 1783077: goto Le;
                default: goto Lc;
            }
        Lc:
            goto L3
        Ld:
            return
        Le:
            com.google.ads.showReward.m830()
            r0 = -1060790147(0xffffffffc0c5a07d, float:-6.175841)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.<init>():void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 190
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:64)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    /* renamed from: ̍, reason: not valid java name and contains not printable characters */
    public static boolean m728(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m728(android.content.Context):boolean");
    }

    /* renamed from: ̎, reason: not valid java name and contains not printable characters */
    public static String m729(String str) {
        char[] m748 = m748(str);
        int i11 = 0;
        while (i11 < m748.length) {
            char c11 = m748[i11];
            m748[i11] = (char) ((c11 & 37650) | ((c11 ^ 65535) & 27885));
            if (((i11 + 22) + 1) - 22 < m748.length) {
                i11 = (i11 - 10) + 1 + 10;
                char c12 = m748[i11];
                m748[i11] = (char) ((c12 & (i11 ^ (-1))) | ((c12 ^ 65535) & i11));
            }
            i11 = 1 - (0 - i11);
        }
        return new String(m748);
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
    /* renamed from: ̐, reason: not valid java name and contains not printable characters */
    public static int m730(java.lang.Object r2, java.lang.Object r3) {
        /*
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = (java.lang.String) r3
            int r1 = com.google.ads.VungleAdActivity.m809(r2, r3)
        L8:
            com.google.ads.VungleAdActivity.m806()
            r0 = 52997895(0x328af07, float:4.9571684E-37)
        Le:
            switch(r0) {
                case -704581992: goto L1c;
                case 52997895: goto L15;
                default: goto L11;
            }
        L11:
            com.google.ads.VungleAdActivity.m806()
            goto L8
        L15:
            com.google.ads.NativeAd.m788()
            r0 = -704581992(0xffffffffd600ee98, float:-3.544056E13)
            goto Le
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m730(java.lang.Object, java.lang.Object):int");
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
    /* renamed from: ̒, reason: not valid java name and contains not printable characters */
    public static boolean m731() {
        /*
        L0:
            r0 = 53079849(0x329ef29, float:4.993918E-37)
        L3:
            switch(r0) {
                case -998071978: goto L11;
                case 53079849: goto La;
                default: goto L6;
            }
        L6:
            com.google.ads.showAd.m825()
            goto L0
        La:
            com.google.ads.NativeAd.m788()
            r0 = -998071978(0xffffffffc482a156, float:-1045.0417)
            goto L3
        L11:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m731():boolean");
    }

    /* renamed from: ̓, reason: not valid java name and contains not printable characters */
    public static byte[] m732(Object obj, int i11) {
        return Base64.decode((String) obj, i11);
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
    /* renamed from: ̔, reason: not valid java name and contains not printable characters */
    public static boolean m733(java.lang.Object r2, java.lang.Object r3) {
        /*
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = (java.lang.String) r3
            boolean r1 = com.google.ads.VungleAdActivity.m805(r2, r3)
        L8:
            r0 = 52968296(0x3283b68, float:4.943896E-37)
        Lb:
            switch(r0) {
                case -1291350089: goto L1c;
                case 52968296: goto L12;
                default: goto Le;
            }
        Le:
            com.google.ads.showAd.m825()
            goto L8
        L12:
            m751()
            r0 = -1291350089(0xffffffffb3078fb7, float:-3.1562845E-8)
            m751()
            goto Lb
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m733(java.lang.Object, java.lang.Object):boolean");
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
    /* renamed from: ̕, reason: not valid java name and contains not printable characters */
    public static java.lang.String m734(java.lang.Object r2) {
        /*
            byte[] r2 = (byte[]) r2
            java.lang.String r1 = com.google.ads.TTRewardAd.m801(r2)
        L6:
            r0 = 53055614(0x329907e, float:4.9830505E-37)
        L9:
            switch(r0) {
                case -142532550: goto L14;
                case 53055614: goto L10;
                default: goto Lc;
            }
        Lc:
            com.google.ads.showAd.m825()
            goto L6
        L10:
            r0 = -142532550(0xfffffffff781203a, float:-5.237968E33)
            goto L9
        L14:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m734(java.lang.Object):java.lang.String");
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
    /* renamed from: ̖, reason: not valid java name and contains not printable characters */
    public static byte[] m735(java.lang.Object r2) {
        /*
            java.lang.String r2 = (java.lang.String) r2
            byte[] r1 = com.google.ads.NativeAd.m791(r2)
        L6:
            r0 = 53017731(0x328fc83, float:4.966063E-37)
        L9:
            switch(r0) {
                case -435993243: goto L1a;
                case 53017731: goto L10;
                default: goto Lc;
            }
        Lc:
            com.google.ads.showAd.m825()
            goto L6
        L10:
            com.google.ads.showReward.m830()
            r0 = -435993243(0xffffffffe6034565, float:-1.5497753E23)
            com.google.ads.showAd.m825()
            goto L9
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m735(java.lang.Object):byte[]");
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
    /* renamed from: ̗, reason: not valid java name and contains not printable characters */
    public static java.lang.Boolean m736(boolean r2) {
        /*
            java.lang.Boolean r1 = com.google.ads.NativeAd.m790(r2)
        L4:
            com.google.ads.showAd.m825()
            r0 = 52953808(0x32802d0, float:4.937399E-37)
        La:
            switch(r0) {
                case -729373240: goto L1b;
                case 52953808: goto L11;
                default: goto Ld;
            }
        Ld:
            com.google.ads.showAd.m825()
            goto L4
        L11:
            com.google.ads.NativeAd.m788()
            r0 = -729373240(0xffffffffd486a5c8, float:-4.6264557E12)
            m751()
            goto La
        L1b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m736(boolean):java.lang.Boolean");
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
    public static java.lang.String m737(java.lang.Object r2) {
        /*
            java.lang.StringBuilder r2 = (java.lang.StringBuilder) r2
            java.lang.String r1 = com.google.ads.showAd.m823(r2)
        L6:
            com.google.ads.showAd.m825()
            r0 = 52975104(0x3285600, float:4.9469486E-37)
        Lc:
            switch(r0) {
                case -1261642148: goto L1d;
                case 52975104: goto L13;
                default: goto Lf;
            }
        Lf:
            com.google.ads.showAd.m825()
            goto L6
        L13:
            com.google.ads.VungleAdActivity.m806()
            r0 = -1261642148(0xffffffffb4ccde5c, float:-3.815975E-7)
            m751()
            goto Lc
        L1d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m737(java.lang.Object):java.lang.String");
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
    /* renamed from: ̙, reason: not valid java name and contains not printable characters */
    public static java.lang.Object m738(java.lang.Object r2, java.lang.Object r3) {
        /*
            java.lang.reflect.Constructor r2 = (java.lang.reflect.Constructor) r2
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            java.lang.Object r1 = com.google.ads.showAd.m829(r2, r3)
        L8:
            r0 = 53016642(0x328f842, float:4.965575E-37)
        Lb:
            switch(r0) {
                case -252769802: goto Lf;
                case 53016642: goto L10;
                default: goto Le;
            }
        Le:
            goto L8
        Lf:
            return r1
        L10:
            com.google.ads.showAd.m825()
            r0 = -252769802(0xfffffffff0ef09f6, float:-5.9183168E29)
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m738(java.lang.Object, java.lang.Object):java.lang.Object");
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
    /* renamed from: ̚, reason: not valid java name and contains not printable characters */
    public static boolean m739(java.lang.Object r2, java.lang.Object r3) {
        /*
            java.lang.String r2 = (java.lang.String) r2
            boolean r1 = com.google.ads.showAd.m827(r2, r3)
        L6:
            r0 = 53024357(0x3291665, float:4.9690344E-37)
        L9:
            switch(r0) {
                case -622917474: goto L1a;
                case 53024357: goto L10;
                default: goto Lc;
            }
        Lc:
            m751()
            goto L6
        L10:
            com.google.ads.showReward.m830()
            r0 = -622917474(0xffffffffdadf089e, float:-3.13891973E16)
            com.google.ads.showReward.m830()
            goto L9
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m739(java.lang.Object, java.lang.Object):boolean");
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
    /* renamed from: ̜, reason: not valid java name and contains not printable characters */
    public static java.security.MessageDigest m740(java.lang.Object r2) {
        /*
            java.lang.String r2 = (java.lang.String) r2
            java.security.MessageDigest r1 = com.google.ads.TTRewardAd.m802(r2)
        L6:
            m751()
            r0 = 53046427(0x3296c9b, float:4.978931E-37)
        Lc:
            switch(r0) {
                case -1397029392: goto L1a;
                case 53046427: goto L13;
                default: goto Lf;
            }
        Lf:
            com.google.ads.VungleAdActivity.m806()
            goto L6
        L13:
            com.google.ads.VungleAdActivity.m806()
            r0 = -1397029392(0xffffffffacbb05f0, float:-5.315519E-12)
            goto Lc
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m740(java.lang.Object):java.security.MessageDigest");
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
    /* renamed from: ̝, reason: not valid java name and contains not printable characters */
    public static boolean m741(java.lang.Object r2, java.lang.Object r3) {
        /*
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = (java.lang.String) r3
            boolean r1 = com.google.ads.TTRewardAd.m799(r2, r3)
        L8:
            com.google.ads.NativeAd.m788()
            r0 = 53081016(0x329f3b8, float:4.994441E-37)
        Le:
            switch(r0) {
                case 53081016: goto L12;
                case 839208551: goto L19;
                default: goto L11;
            }
        L11:
            goto L8
        L12:
            r0 = 839208551(0x32054e67, float:7.7594455E-9)
            com.google.ads.showAd.m825()
            goto Le
        L19:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m741(java.lang.Object, java.lang.Object):boolean");
    }

    /* renamed from: ̞, reason: not valid java name and contains not printable characters */
    public static boolean m742(Object obj) {
        return RewardAd.m794((Context) obj);
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
    /* renamed from: ̟, reason: not valid java name and contains not printable characters */
    public static byte[] m743(java.lang.Object r2, int r3) {
        /*
            java.lang.String r2 = (java.lang.String) r2
            byte[] r1 = m732(r2, r3)
        L6:
            com.google.ads.showReward.m830()
            r0 = 52954910(0x328071e, float:4.9378933E-37)
        Lc:
            switch(r0) {
                case 52954910: goto L13;
                case 545751905: goto L17;
                default: goto Lf;
            }
        Lf:
            m751()
            goto L6
        L13:
            r0 = 545751905(0x20878361, float:2.295683E-19)
            goto Lc
        L17:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m743(java.lang.Object, int):byte[]");
    }

    /* renamed from: ̠, reason: not valid java name and contains not printable characters */
    public static int m744(Object obj) {
        return ((String) obj).hashCode();
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
    /* renamed from: ̡, reason: not valid java name and contains not printable characters */
    public static void m745(java.lang.Object r1, java.lang.Object r2) {
        /*
            java.security.MessageDigest r1 = (java.security.MessageDigest) r1
            byte[] r2 = (byte[]) r2
            m746(r1, r2)
        L7:
            r0 = 52967564(0x328388c, float:4.9435675E-37)
        La:
            switch(r0) {
                case 52967564: goto L11;
                case 252360275: goto L18;
                default: goto Ld;
            }
        Ld:
            m751()
            goto L7
        L11:
            r0 = 252360275(0xf0ab653, float:6.83904E-30)
            com.google.ads.VungleAdActivity.m806()
            goto La
        L18:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m745(java.lang.Object, java.lang.Object):void");
    }

    /* renamed from: ̢, reason: not valid java name and contains not printable characters */
    public static void m746(Object obj, Object obj2) {
        ((MessageDigest) obj).update((byte[]) obj2);
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
    /* renamed from: ̩, reason: not valid java name and contains not printable characters */
    public static java.io.File m747(java.lang.Object r2) {
        /*
            java.io.File r2 = (java.io.File) r2
            java.io.File r1 = com.google.ads.NativeAd.m792(r2)
        L6:
            com.google.ads.showAd.m825()
            r0 = 53078468(0x329e9c4, float:4.9932986E-37)
        Lc:
            switch(r0) {
                case 53078468: goto L10;
                case 1401060240: goto L1a;
                default: goto Lf;
            }
        Lf:
            goto L6
        L10:
            com.google.ads.showAd.m825()
            r0 = 1401060240(0x53827b90, float:1.12083757E12)
            com.google.ads.showAd.m825()
            goto Lc
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m747(java.lang.Object):java.io.File");
    }

    /* renamed from: ̪, reason: not valid java name and contains not printable characters */
    public static char[] m748(Object obj) {
        return ((String) obj).toCharArray();
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
    /* renamed from: ̫, reason: not valid java name and contains not printable characters */
    public static java.lang.reflect.Constructor m749(java.lang.Object r2, java.lang.Object r3) {
        /*
            java.lang.Class r2 = (java.lang.Class) r2
            java.lang.Class[] r3 = (java.lang.Class[]) r3
            java.lang.reflect.Constructor r1 = com.google.ads.VungleAdActivity.m804(r2, r3)
        L8:
            r0 = 52967344(0x32837b0, float:4.943469E-37)
        Lb:
            switch(r0) {
                case 52967344: goto Lf;
                case 1107731014: goto L13;
                default: goto Le;
            }
        Le:
            goto L8
        Lf:
            r0 = 1107731014(0x4206a246, float:33.65847)
            goto Lb
        L13:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m749(java.lang.Object, java.lang.Object):java.lang.reflect.Constructor");
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
    /* renamed from: ̬, reason: not valid java name and contains not printable characters */
    public static int m750(java.lang.Object r2) {
        /*
            int r1 = com.google.ads.TTRewardAd.m800(r2)
        L4:
            com.google.ads.VungleAdActivity.m806()
            r0 = 53060309(0x329a2d5, float:4.985156E-37)
        La:
            switch(r0) {
                case 53060309: goto L11;
                case 814235077: goto L1b;
                default: goto Ld;
            }
        Ld:
            com.google.ads.showAd.m825()
            goto L4
        L11:
            com.google.ads.showReward.m830()
            r0 = 814235077(0x30883dc5, float:9.912858E-10)
            com.google.ads.showAd.m825()
            goto La
        L1b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m750(java.lang.Object):int");
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
    /* renamed from: ̯, reason: not valid java name and contains not printable characters */
    public static int m751() {
        /*
        L0:
            r0 = 53030782(0x3292f7e, float:4.9719155E-37)
        L3:
            switch(r0) {
                case 53030782: goto L7;
                case 282158370: goto Lb;
                default: goto L6;
            }
        L6:
            goto L0
        L7:
            r0 = 282158370(0x10d16522, float:8.2591784E-29)
            goto L3
        Lb:
            r0 = 4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m751():int");
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
    /* renamed from: ̲, reason: not valid java name and contains not printable characters */
    public static android.content.pm.ApplicationInfo m752(java.lang.Object r2) {
        /*
            android.content.Context r2 = (android.content.Context) r2
            android.content.pm.ApplicationInfo r1 = com.google.ads.VungleAdActivity.m803(r2)
        L6:
            com.google.ads.NativeAd.m788()
            r0 = 54000795(0x337fc9b, float:5.4068843E-37)
        Lc:
            switch(r0) {
                case -1653709381: goto L1a;
                case 54000795: goto L13;
                default: goto Lf;
            }
        Lf:
            com.google.ads.showAd.m825()
            goto L6
        L13:
            com.google.ads.NativeAd.m788()
            r0 = -1653709381(0xffffffff9d6e65bb, float:-3.1551631E-21)
            goto Lc
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m752(java.lang.Object):android.content.pm.ApplicationInfo");
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
    /* renamed from: ̳, reason: not valid java name and contains not printable characters */
    public static int m753(java.lang.Object r2) {
        /*
            int r1 = com.google.ads.TTRewardAd.m800(r2)
        L4:
            r0 = 53791452(0x334cadc, float:5.3130117E-37)
        L7:
            switch(r0) {
                case -2023818309: goto Lb;
                case 53791452: goto Lc;
                default: goto La;
            }
        La:
            goto L4
        Lb:
            return r1
        Lc:
            r0 = -2023818309(0xffffffff875efbbb, float:-1.6775401E-34)
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m753(java.lang.Object):int");
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
    /* renamed from: ̳, reason: not valid java name and contains not printable characters */
    public static java.lang.Class<?> m754(java.lang.String r2) throws java.lang.ClassNotFoundException {
        /*
            java.lang.Class r1 = com.google.ads.VungleAdActivity.m808(r2)
        L4:
            r0 = 53862926(0x335e20e, float:5.3450617E-37)
        L7:
            switch(r0) {
                case 53862926: goto Le;
                case 1497048017: goto L15;
                default: goto La;
            }
        La:
            com.google.ads.showReward.m830()
            goto L4
        Le:
            com.google.ads.NativeAd.m788()
            r0 = 1497048017(0x593b23d1, float:3.29220008E15)
            goto L7
        L15:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m754(java.lang.String):java.lang.Class");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
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
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0035. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0010. Please report as an issue. */
    /* renamed from: ̳, reason: not valid java name and contains not printable characters */
    public static java.lang.String m755(short[] r5, int r6, int r7, int r8) {
        /*
            char[] r2 = new char[r7]
            r0 = 0
        L3:
            r1 = 53872064(0x33605c0, float:5.3491594E-37)
            com.google.ads.VungleAdActivity.m806()
        L9:
            r3 = r1 ^ (-1)
            r3 = r3 & 7128(0x1bd8, float:9.988E-42)
            r1 = r1 & (-7129(0xffffffffffffe427, float:NaN))
            r1 = r1 | r3
        L10:
            switch(r1) {
                case -1872852022: goto L17;
                case 53878296: goto L5d;
                case 786952841: goto L46;
                default: goto L13;
            }
        L13:
            m751()
            goto L3
        L17:
            int r1 = r6 + 18
            int r1 = r1 + r0
            int r1 = r1 + (-18)
            short r1 = r5[r1]
            r3 = r1 ^ (-1)
            r3 = r3 & r8
            r4 = r8 ^ (-1)
            r1 = r1 & r4
            r1 = r1 | r3
            char r1 = (char) r1
            char r1 = (char) r1
            r2[r0] = r1
            int r0 = 0 - r0
            int r0 = r0 + (-1)
            int r0 = 0 - r0
        L2f:
            com.google.ads.showReward.m830()
            r1 = 53925393(0x336d611, float:5.373073E-37)
        L35:
            switch(r1) {
                case -855084582: goto L3;
                case 53925393: goto L3c;
                default: goto L38;
            }
        L38:
            com.google.ads.showAd.m825()
            goto L2f
        L3c:
            com.google.ads.showReward.m830()
            r1 = -855084582(0xffffffffcd0871da, float:-1.43072672E8)
            com.google.ads.NativeAd.m788()
            goto L35
        L46:
            com.google.ads.NativeAd.m788()
            java.lang.String r1 = new java.lang.String
            r1.<init>(r2)
        L4e:
            r0 = 53911485(0x3369fbd, float:5.3668364E-37)
        L51:
            switch(r0) {
                case -1148505386: goto L55;
                case 53911485: goto L56;
                default: goto L54;
            }
        L54:
            goto L4e
        L55:
            return r1
        L56:
            com.google.ads.NativeAd.m788()
            r0 = -1148505386(0xffffffffbb8b32d6, float:-0.0042480035)
            goto L51
        L5d:
            if (r0 >= r7) goto L69
            com.google.ads.VungleAdActivity.m806()
            r1 = -1872852022(0xffffffff905e8bca, float:-4.388947E-29)
            com.google.ads.showAd.m825()
            goto L10
        L69:
            r1 = 786950481(0x2ee7e951, float:1.0546109E-10)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m755(short[], int, int, int):java.lang.String");
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
    /* renamed from: ̶, reason: not valid java name and contains not printable characters */
    public static java.lang.Integer m756(int r2) {
        /*
            java.lang.Integer r1 = com.google.ads.showAd.m826(r2)
        L4:
            r0 = 53928195(0x336e103, float:5.3743294E-37)
        L7:
            switch(r0) {
                case 281507: goto L15;
                case 53928195: goto Le;
                default: goto La;
            }
        La:
            com.google.ads.showReward.m830()
            goto L4
        Le:
            r0 = 281507(0x44ba3, float:3.94475E-40)
            com.google.ads.showAd.m825()
            goto L7
        L15:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.m756(int):java.lang.Integer");
    }
}
