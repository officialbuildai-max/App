package com.google.android.exoplayer2.audio;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.provider.Settings;
import android.util.Pair;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.r4;
import com.google.common.primitives.Ints;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final f f24714c = new f(new int[]{2}, 8);

    /* renamed from: d, reason: collision with root package name */
    private static final f f24715d = new f(new int[]{2, 5, 6}, 8);

    /* renamed from: e, reason: collision with root package name */
    private static final ImmutableMap f24716e = new ImmutableMap.b().h(5, 6).h(17, 6).h(7, 6).h(18, 6).h(6, 8).h(8, 8).h(14, 8).d();

    /* renamed from: a, reason: collision with root package name */
    private final int[] f24717a;

    /* renamed from: b, reason: collision with root package name */
    private final int f24718b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final AudioAttributes f24719a = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

        public static int[] a() {
            boolean isDirectPlaybackSupported;
            ImmutableList.a builder = ImmutableList.builder();
            r4 it = f.f24716e.keySet().iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                isDirectPlaybackSupported = AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(num.intValue()).setSampleRate(48000).build(), f24719a);
                if (isDirectPlaybackSupported) {
                    builder.a(num);
                }
            }
            builder.a(2);
            return Ints.o(builder.e());
        }

        public static int b(int i11, int i12) {
            boolean isDirectPlaybackSupported;
            for (int i13 = 8; i13 > 0; i13--) {
                isDirectPlaybackSupported = AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i11).setSampleRate(i12).setChannelMask(p0.G(i13)).build(), f24719a);
                if (isDirectPlaybackSupported) {
                    return i13;
                }
            }
            return 0;
        }
    }

    public f(int[] iArr, int i11) {
        if (iArr != null) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.f24717a = copyOf;
            Arrays.sort(copyOf);
        } else {
            this.f24717a = new int[0];
        }
        this.f24718b = i11;
    }

    private static boolean b() {
        if (p0.f27680a >= 17) {
            String str = p0.f27682c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static f c(Context context) {
        return d(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    static f d(Context context, Intent intent) {
        return (b() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) ? f24715d : (p0.f27680a < 29 || !(p0.x0(context) || p0.s0(context))) ? (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? f24714c : new f(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8)) : new f(a.a(), 8);
    }

    private static int e(int i11) {
        int i12 = p0.f27680a;
        if (i12 <= 28) {
            if (i11 == 7) {
                i11 = 8;
            } else if (i11 == 3 || i11 == 4 || i11 == 5) {
                i11 = 6;
            }
        }
        if (i12 <= 26 && "fugu".equals(p0.f27681b) && i11 == 1) {
            i11 = 2;
        }
        return p0.G(i11);
    }

    private static int g(int i11, int i12) {
        return p0.f27680a >= 29 ? a.b(i11, i12) : ((Integer) com.google.android.exoplayer2.util.a.e((Integer) f24716e.getOrDefault(Integer.valueOf(i11), 0))).intValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Arrays.equals(this.f24717a, fVar.f24717a) && this.f24718b == fVar.f24718b;
    }

    public Pair f(o1 o1Var) {
        int f11 = com.google.android.exoplayer2.util.w.f((String) com.google.android.exoplayer2.util.a.e(o1Var.f25550l), o1Var.f25547i);
        if (!f24716e.containsKey(Integer.valueOf(f11))) {
            return null;
        }
        if (f11 == 18 && !i(18)) {
            f11 = 6;
        } else if (f11 == 8 && !i(8)) {
            f11 = 7;
        }
        if (!i(f11)) {
            return null;
        }
        int i11 = o1Var.f25563y;
        if (i11 == -1 || f11 == 18) {
            int i12 = o1Var.f25564z;
            if (i12 == -1) {
                i12 = 48000;
            }
            i11 = g(f11, i12);
        } else if (i11 > this.f24718b) {
            return null;
        }
        int e11 = e(i11);
        if (e11 == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(f11), Integer.valueOf(e11));
    }

    public boolean h(o1 o1Var) {
        return f(o1Var) != null;
    }

    public int hashCode() {
        return this.f24718b + (Arrays.hashCode(this.f24717a) * 31);
    }

    public boolean i(int i11) {
        return Arrays.binarySearch(this.f24717a, i11) >= 0;
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f24718b + ", supportedEncodings=" + Arrays.toString(this.f24717a) + "]";
    }
}
