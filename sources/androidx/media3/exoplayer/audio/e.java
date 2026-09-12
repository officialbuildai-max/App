package androidx.media3.exoplayer.audio;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioProfile;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import android.util.SparseArray;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.r4;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f11244c = new e(ImmutableList.of(C0102e.f11249d));

    /* renamed from: d, reason: collision with root package name */
    private static final ImmutableList f11245d = ImmutableList.of(2, 5, 6);

    /* renamed from: e, reason: collision with root package name */
    static final ImmutableMap f11246e = new ImmutableMap.b().h(5, 6).h(17, 6).h(7, 6).h(30, 10).h(18, 6).h(6, 8).h(8, 8).h(14, 8).d();

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray f11247a;

    /* renamed from: b, reason: collision with root package name */
    private final int f11248b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {
        private static ImmutableSet a() {
            ImmutableSet.a k11 = new ImmutableSet.a().k(8, 7);
            int i11 = androidx.media3.common.util.a1.f10432a;
            if (i11 >= 31) {
                k11.k(26, 27);
            }
            if (i11 >= 33) {
                k11.a(30);
            }
            return k11.e();
        }

        public static boolean b(AudioManager audioManager, j jVar) {
            AudioDeviceInfo[] devices = jVar == null ? ((AudioManager) androidx.media3.common.util.a.e(audioManager)).getDevices(2) : new AudioDeviceInfo[]{jVar.f11278a};
            ImmutableSet a11 = a();
            for (AudioDeviceInfo audioDeviceInfo : devices) {
                if (a11.contains(Integer.valueOf(audioDeviceInfo.getType()))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {
        public static ImmutableList a(androidx.media3.common.c cVar) {
            boolean isDirectPlaybackSupported;
            ImmutableList.a builder = ImmutableList.builder();
            r4 it = e.f11246e.keySet().iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                int intValue = num.intValue();
                if (androidx.media3.common.util.a1.f10432a >= androidx.media3.common.util.a1.K(intValue)) {
                    isDirectPlaybackSupported = AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), cVar.a().f10001a);
                    if (isDirectPlaybackSupported) {
                        builder.a(num);
                    }
                }
            }
            builder.a(2);
            return builder.e();
        }

        public static int b(int i11, int i12, androidx.media3.common.c cVar) {
            boolean isDirectPlaybackSupported;
            for (int i13 = 10; i13 > 0; i13--) {
                int M = androidx.media3.common.util.a1.M(i13);
                if (M != 0) {
                    isDirectPlaybackSupported = AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i11).setSampleRate(i12).setChannelMask(M).build(), cVar.a().f10001a);
                    if (isDirectPlaybackSupported) {
                        return i13;
                    }
                }
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d {
        public static e a(AudioManager audioManager, androidx.media3.common.c cVar) {
            List directProfilesForAttributes;
            directProfilesForAttributes = audioManager.getDirectProfilesForAttributes(cVar.a().f10001a);
            return new e(e.c(directProfilesForAttributes));
        }

        public static j b(AudioManager audioManager, androidx.media3.common.c cVar) {
            List audioDevicesForAttributes;
            try {
                audioDevicesForAttributes = ((AudioManager) androidx.media3.common.util.a.e(audioManager)).getAudioDevicesForAttributes(cVar.a().f10001a);
                if (audioDevicesForAttributes.isEmpty()) {
                    return null;
                }
                return new j((AudioDeviceInfo) audioDevicesForAttributes.get(0));
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.media3.exoplayer.audio.e$e, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0102e {

        /* renamed from: d, reason: collision with root package name */
        public static final C0102e f11249d;

        /* renamed from: a, reason: collision with root package name */
        public final int f11250a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11251b;

        /* renamed from: c, reason: collision with root package name */
        private final ImmutableSet f11252c;

        static {
            f11249d = androidx.media3.common.util.a1.f10432a >= 33 ? new C0102e(2, a(10)) : new C0102e(2, 10);
        }

        public C0102e(int i11, int i12) {
            this.f11250a = i11;
            this.f11251b = i12;
            this.f11252c = null;
        }

        public C0102e(int i11, Set set) {
            this.f11250a = i11;
            ImmutableSet copyOf = ImmutableSet.copyOf((Collection) set);
            this.f11252c = copyOf;
            r4 it = copyOf.iterator();
            int i12 = 0;
            while (it.hasNext()) {
                i12 = Math.max(i12, Integer.bitCount(((Integer) it.next()).intValue()));
            }
            this.f11251b = i12;
        }

        private static ImmutableSet a(int i11) {
            ImmutableSet.a aVar = new ImmutableSet.a();
            for (int i12 = 1; i12 <= i11; i12++) {
                aVar.a(Integer.valueOf(androidx.media3.common.util.a1.M(i12)));
            }
            return aVar.e();
        }

        public int b(int i11, androidx.media3.common.c cVar) {
            return this.f11252c != null ? this.f11251b : androidx.media3.common.util.a1.f10432a >= 29 ? c.b(this.f11250a, i11, cVar) : ((Integer) androidx.media3.common.util.a.e((Integer) e.f11246e.getOrDefault(Integer.valueOf(this.f11250a), 0))).intValue();
        }

        public boolean c(int i11) {
            if (this.f11252c == null) {
                return i11 <= this.f11251b;
            }
            int M = androidx.media3.common.util.a1.M(i11);
            if (M == 0) {
                return false;
            }
            return this.f11252c.contains(Integer.valueOf(M));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0102e)) {
                return false;
            }
            C0102e c0102e = (C0102e) obj;
            return this.f11250a == c0102e.f11250a && this.f11251b == c0102e.f11251b && Objects.equals(this.f11252c, c0102e.f11252c);
        }

        public int hashCode() {
            int i11 = ((this.f11250a * 31) + this.f11251b) * 31;
            ImmutableSet immutableSet = this.f11252c;
            return i11 + (immutableSet == null ? 0 : immutableSet.hashCode());
        }

        public String toString() {
            return "AudioProfile[format=" + this.f11250a + ", maxChannelCount=" + this.f11251b + ", channelMasks=" + this.f11252c + "]";
        }
    }

    private e(List list) {
        this.f11247a = new SparseArray();
        for (int i11 = 0; i11 < list.size(); i11++) {
            C0102e c0102e = (C0102e) list.get(i11);
            this.f11247a.put(c0102e.f11250a, c0102e);
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f11247a.size(); i13++) {
            i12 = Math.max(i12, ((C0102e) this.f11247a.valueAt(i13)).f11251b);
        }
        this.f11248b = i12;
    }

    private static boolean b() {
        String str = Build.MANUFACTURER;
        return str.equals("Amazon") || str.equals("Xiaomi");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ImmutableList c(List list) {
        int encapsulationType;
        int format;
        int[] channelMasks;
        int[] channelMasks2;
        HashMap hashMap = new HashMap();
        hashMap.put(2, new HashSet(Ints.c(12)));
        for (int i11 = 0; i11 < list.size(); i11++) {
            AudioProfile a11 = androidx.media3.exoplayer.audio.a.a(list.get(i11));
            encapsulationType = a11.getEncapsulationType();
            if (encapsulationType != 1) {
                format = a11.getFormat();
                if (androidx.media3.common.util.a1.G0(format) || f11246e.containsKey(Integer.valueOf(format))) {
                    if (hashMap.containsKey(Integer.valueOf(format))) {
                        Set set = (Set) androidx.media3.common.util.a.e((Set) hashMap.get(Integer.valueOf(format)));
                        channelMasks2 = a11.getChannelMasks();
                        set.addAll(Ints.c(channelMasks2));
                    } else {
                        Integer valueOf = Integer.valueOf(format);
                        channelMasks = a11.getChannelMasks();
                        hashMap.put(valueOf, new HashSet(Ints.c(channelMasks)));
                    }
                }
            }
        }
        ImmutableList.a builder = ImmutableList.builder();
        for (Map.Entry entry : hashMap.entrySet()) {
            builder.a(new C0102e(((Integer) entry.getKey()).intValue(), (Set) entry.getValue()));
        }
        return builder.e();
    }

    private static ImmutableList d(int[] iArr, int i11) {
        ImmutableList.a builder = ImmutableList.builder();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int i12 : iArr) {
            builder.a(new C0102e(i12, i11));
        }
        return builder.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e e(Context context, Intent intent, androidx.media3.common.c cVar, j jVar) {
        AudioManager c11 = t1.m.c(context);
        if (jVar == null) {
            jVar = androidx.media3.common.util.a1.f10432a >= 33 ? d.b(c11, cVar) : null;
        }
        int i11 = androidx.media3.common.util.a1.f10432a;
        if (i11 >= 33 && (androidx.media3.common.util.a1.K0(context) || androidx.media3.common.util.a1.D0(context))) {
            return d.a(c11, cVar);
        }
        if (i11 >= 23 && b.b(c11, jVar)) {
            return f11244c;
        }
        ImmutableSet.a aVar = new ImmutableSet.a();
        aVar.a(2);
        if (i11 >= 29 && (androidx.media3.common.util.a1.K0(context) || androidx.media3.common.util.a1.D0(context))) {
            aVar.l(c.a(cVar));
            return new e(d(Ints.o(aVar.e()), 10));
        }
        ContentResolver contentResolver = context.getContentResolver();
        boolean z10 = Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1;
        if ((z10 || b()) && Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
            aVar.l(f11245d);
        }
        if (intent == null || z10 || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
            return new e(d(Ints.o(aVar.e()), 10));
        }
        int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
        if (intArrayExtra != null) {
            aVar.l(Ints.c(intArrayExtra));
        }
        return new e(d(Ints.o(aVar.e()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e f(Context context, androidx.media3.common.c cVar, j jVar) {
        return e(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), cVar, jVar);
    }

    private static int g(int i11) {
        int i12 = androidx.media3.common.util.a1.f10432a;
        if (i12 <= 28) {
            if (i11 == 7) {
                i11 = 8;
            } else if (i11 == 3 || i11 == 4 || i11 == 5) {
                i11 = 6;
            }
        }
        if (i12 <= 26 && "fugu".equals(Build.DEVICE) && i11 == 1) {
            i11 = 2;
        }
        return androidx.media3.common.util.a1.M(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri i() {
        if (b()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return androidx.media3.common.util.a1.t(this.f11247a, eVar.f11247a) && this.f11248b == eVar.f11248b;
    }

    public Pair h(androidx.media3.common.r rVar, androidx.media3.common.c cVar) {
        int f11 = androidx.media3.common.y.f((String) androidx.media3.common.util.a.e(rVar.f10243o), rVar.f10239k);
        if (!f11246e.containsKey(Integer.valueOf(f11))) {
            return null;
        }
        if (f11 == 18 && !k(18)) {
            f11 = 6;
        } else if ((f11 == 8 && !k(8)) || (f11 == 30 && !k(30))) {
            f11 = 7;
        }
        if (!k(f11)) {
            return null;
        }
        C0102e c0102e = (C0102e) androidx.media3.common.util.a.e((C0102e) this.f11247a.get(f11));
        int i11 = rVar.E;
        if (i11 == -1 || f11 == 18) {
            int i12 = rVar.F;
            if (i12 == -1) {
                i12 = 48000;
            }
            i11 = c0102e.b(i12, cVar);
        } else if (!rVar.f10243o.equals("audio/vnd.dts.uhd;profile=p2") || androidx.media3.common.util.a1.f10432a >= 33) {
            if (!c0102e.c(i11)) {
                return null;
            }
        } else if (i11 > 10) {
            return null;
        }
        int g11 = g(i11);
        if (g11 == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(f11), Integer.valueOf(g11));
    }

    public int hashCode() {
        return this.f11248b + (androidx.media3.common.util.a1.u(this.f11247a) * 31);
    }

    public boolean j(androidx.media3.common.r rVar, androidx.media3.common.c cVar) {
        return h(rVar, cVar) != null;
    }

    public boolean k(int i11) {
        return androidx.media3.common.util.a1.r(this.f11247a, i11);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f11248b + ", audioProfiles=" + this.f11247a + "]";
    }
}
