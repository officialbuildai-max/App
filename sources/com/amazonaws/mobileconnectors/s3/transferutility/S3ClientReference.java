package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.services.s3.AmazonS3;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
abstract class S3ClientReference {

    /* renamed from: a, reason: collision with root package name */
    private static Map f18533a = new ConcurrentHashMap();

    public static AmazonS3 a(Integer num) {
        return (AmazonS3) f18533a.get(num);
    }

    public static void b(Integer num, AmazonS3 amazonS3) {
        f18533a.put(num, amazonS3);
    }

    public static void c(Integer num) {
        f18533a.remove(num);
    }
}
