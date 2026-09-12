package com.amazonaws.regions;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class RegionUtils {

    /* renamed from: a, reason: collision with root package name */
    private static List f18649a;

    /* renamed from: b, reason: collision with root package name */
    private static final Log f18650b = LogFactory.c("com.amazonaws.request");

    public static Region a(String str) {
        for (Region region : c()) {
            if (region.d().equals(str)) {
                return region;
            }
        }
        return null;
    }

    public static Region b(String str) {
        String host = d(str).getHost();
        for (Region region : c()) {
            Iterator it = region.h().values().iterator();
            while (it.hasNext()) {
                if (d((String) it.next()).getHost().equals(host)) {
                    return region;
                }
            }
        }
        throw new IllegalArgumentException("No region found with any service for endpoint " + str);
    }

    public static synchronized List c() {
        List list;
        synchronized (RegionUtils.class) {
            try {
                if (f18649a == null) {
                    e();
                }
                list = f18649a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return list;
    }

    private static URI d(String str) {
        try {
            URI uri = new URI(str);
            if (uri.getHost() != null) {
                return uri;
            }
            return new URI("http://" + str);
        } catch (URISyntaxException e11) {
            throw new RuntimeException("Unable to parse service endpoint: " + e11.getMessage());
        }
    }

    public static synchronized void e() {
        synchronized (RegionUtils.class) {
            if (System.getProperty("com.amazonaws.regions.RegionUtils.fileOverride") != null) {
                try {
                    h();
                } catch (FileNotFoundException e11) {
                    throw new RuntimeException("Couldn't find regions override file specified", e11);
                }
            }
            if (f18649a == null) {
                g();
            }
            if (f18649a == null) {
                throw new RuntimeException("Failed to initialize the regions.");
            }
        }
    }

    private static void f(InputStream inputStream) {
        try {
            f18649a = new RegionMetadataParser().e(inputStream);
        } catch (Exception e11) {
            f18650b.i("Failed to parse regional endpoints", e11);
        }
    }

    private static void g() {
        Log log = f18650b;
        if (log.b()) {
            log.a("Initializing the regions with default regions");
        }
        f18649a = RegionDefaults.a();
    }

    private static void h() {
        String property = System.getProperty("com.amazonaws.regions.RegionUtils.fileOverride");
        Log log = f18650b;
        if (log.b()) {
            log.a("Using local override of the regions file (" + property + ") to initiate regions data...");
        }
        f(new FileInputStream(new File(property)));
    }
}
