package com.bykv.vk.openvk.preload.geckox.buffer.a;

import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f20714a;

    /* renamed from: b, reason: collision with root package name */
    public String f20715b;

    /* renamed from: c, reason: collision with root package name */
    public String f20716c;

    /* renamed from: d, reason: collision with root package name */
    public String f20717d;

    /* renamed from: e, reason: collision with root package name */
    public String f20718e;

    /* renamed from: f, reason: collision with root package name */
    public String f20719f;

    /* renamed from: g, reason: collision with root package name */
    public int f20720g;

    public static com.bykv.vk.openvk.preload.geckox.buffer.a a(File file, long j11) throws IOException {
        com.bykv.vk.openvk.preload.geckox.buffer.a b11 = b(file, j11);
        GeckoLogger.d("gecko-debug-tag", "buffer type:" + b11.getClass());
        return b11;
    }

    private static com.bykv.vk.openvk.preload.geckox.buffer.a b(File file, long j11) throws IOException {
        if (j11 <= 0) {
            try {
                return new b(file);
            } catch (Exception e11) {
                throw new IOException("create FileBuffer failed! file:" + file.getAbsolutePath() + " caused by:" + e11.getMessage(), e11);
            }
        }
        try {
            return new c(j11, file);
        } catch (Exception e12) {
            throw new RuntimeException("create random access file failed! file:" + file.getAbsolutePath() + " caused by:" + e12.getMessage(), e12);
        }
    }
}
