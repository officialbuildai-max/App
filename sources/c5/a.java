package c5;

import org.glassfish.jersey.internal.spi.AutoDiscoverable;

/* loaded from: classes2.dex */
public class a implements AutoDiscoverable {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f17083a = true;

    static {
        try {
            f17083a = Boolean.parseBoolean(System.getProperty("fastjson.auto.discoverable", String.valueOf(f17083a)));
        } catch (Throwable unused) {
        }
    }
}
