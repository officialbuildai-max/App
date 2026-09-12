package com.apm.insight.l;

import android.annotation.TargetApi;
import android.os.Debug;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static a f19741a = new b(0);

    /* renamed from: com.apm.insight.l.c$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static int a(Object obj, int i11) {
            if (obj == null) {
                return i11;
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof String) {
                try {
                    return Integer.parseInt(String.valueOf(obj));
                } catch (Throwable unused) {
                }
            }
            return i11;
        }

        public static Float a(Map<? super String, Float> map) {
            float f11 = 0.0f;
            for (Float f12 : map.values()) {
                if (f12 != null) {
                    f11 += f12.floatValue();
                }
            }
            return Float.valueOf(f11);
        }

        public static Long a(Map<? super String, Long> map, String str, Long l11) {
            if (str == null || map == null) {
                return -1L;
            }
            Long l12 = map.get(str);
            if (l12 != null) {
                l11 = Long.valueOf(l12.longValue() + l11.longValue());
            }
            map.put(str, l11);
            return l11;
        }
    }

    /* loaded from: classes2.dex */
    static class a {
        private a() {
        }

        /* synthetic */ a(byte b11) {
            this();
        }

        public int a(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int b(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int c(Debug.MemoryInfo memoryInfo) {
            return -1;
        }
    }

    @TargetApi(19)
    /* loaded from: classes2.dex */
    static class b extends a {
        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b11) {
            this();
        }

        @Override // com.apm.insight.l.c.a
        public final int a(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // com.apm.insight.l.c.a
        public final int b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // com.apm.insight.l.c.a
        public final int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    public static int a(Debug.MemoryInfo memoryInfo) {
        return f19741a.a(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return f19741a.b(memoryInfo);
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return f19741a.c(memoryInfo);
    }
}
