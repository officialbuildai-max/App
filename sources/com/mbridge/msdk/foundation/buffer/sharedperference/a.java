package com.mbridge.msdk.foundation.buffer.sharedperference;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.directory.c;
import com.mbridge.msdk.foundation.same.directory.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.o0;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final String f35013b = "a";

    /* renamed from: c, reason: collision with root package name */
    private static a f35014c;

    /* renamed from: a, reason: collision with root package name */
    FastKV f35015a;

    private a() {
    }

    private void a() {
        if (this.f35015a == null) {
            try {
                this.f35015a = new FastKV.Builder(e.b(c.MBRIDGE_700_CONFIG), "mbridge").build();
            } catch (Exception unused) {
                this.f35015a = null;
            }
        }
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f35014c == null) {
                    f35014c = new a();
                }
                aVar = f35014c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public int a(String str, int i11) {
        try {
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.a(f35013b, "getInt error: " + e11.getMessage());
            }
        }
        if (com.mbridge.msdk.foundation.controller.c.m().d() == null) {
            return i11;
        }
        a();
        FastKV fastKV = this.f35015a;
        if (fastKV != null) {
            try {
                return fastKV.getInt(str, i11);
            } catch (Exception unused) {
                return i11;
            }
        }
        return i11;
    }

    public String a(String str) {
        try {
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.a(f35013b, "get error: " + e11.getMessage());
            }
        }
        if (com.mbridge.msdk.foundation.controller.c.m().d() == null) {
            return null;
        }
        a();
        FastKV fastKV = this.f35015a;
        if (fastKV != null) {
            try {
                return fastKV.getString(str, "");
            } catch (Exception unused) {
                return "";
            }
        }
        return null;
    }

    public void a(String str, long j11) {
        try {
            if (com.mbridge.msdk.foundation.controller.c.m().d() == null) {
                o0.b(f35013b, "context is null in put");
                return;
            }
            a();
            FastKV fastKV = this.f35015a;
            if (fastKV != null) {
                try {
                    fastKV.putLong(str, j11);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.a(f35013b, "putLong error: " + e11.getMessage());
            }
        }
    }

    public void a(String str, String str2) {
        try {
            if (com.mbridge.msdk.foundation.controller.c.m().d() == null) {
                return;
            }
            a();
            FastKV fastKV = this.f35015a;
            if (fastKV != null) {
                try {
                    fastKV.putString(str, str2);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.a(f35013b, "put error: " + e11.getMessage());
            }
        }
    }

    public Long b(String str) {
        try {
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.a(f35013b, "getLong error: " + e11.getMessage());
            }
        }
        if (com.mbridge.msdk.foundation.controller.c.m().d() == null) {
            o0.b(f35013b, "context is null in get");
            return 0L;
        }
        a();
        FastKV fastKV = this.f35015a;
        if (fastKV != null) {
            try {
                return Long.valueOf(fastKV.getLong(str, 0L));
            } catch (Exception unused) {
                return 0L;
            }
        }
        return 0L;
    }

    public void b(String str, int i11) {
        try {
            if (com.mbridge.msdk.foundation.controller.c.m().d() == null) {
                return;
            }
            a();
            FastKV fastKV = this.f35015a;
            if (fastKV != null) {
                try {
                    fastKV.putInt(str, i11);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void c(String str) {
        if (com.mbridge.msdk.foundation.controller.c.m().d() == null) {
            return;
        }
        a();
        FastKV fastKV = this.f35015a;
        if (fastKV != null) {
            try {
                fastKV.remove(str);
            } catch (Exception unused) {
            }
        }
    }
}
