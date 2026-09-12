package k7;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.TypeAdapters;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static Gson f66799a;

    public static synchronized Gson a() {
        Gson gson;
        synchronized (e.class) {
            try {
                if (f66799a == null) {
                    f66799a = b().create();
                }
                gson = f66799a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return gson;
    }

    public static GsonBuilder b() {
        return new GsonBuilder().registerTypeAdapterFactory(TypeAdapters.newFactory(String.class, new h())).registerTypeAdapterFactory(TypeAdapters.newFactory(Boolean.TYPE, Boolean.class, new b())).registerTypeAdapterFactory(TypeAdapters.newFactory(Integer.TYPE, Integer.class, new f())).registerTypeAdapterFactory(TypeAdapters.newFactory(Long.TYPE, Long.class, new g())).registerTypeAdapterFactory(TypeAdapters.newFactory(Float.TYPE, Float.class, new d())).registerTypeAdapterFactory(TypeAdapters.newFactory(Double.TYPE, Double.class, new c())).registerTypeAdapterFactory(TypeAdapters.newFactory(BigDecimal.class, new a()));
    }
}
