package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;

/* loaded from: classes7.dex */
class c extends b {

    /* renamed from: b, reason: collision with root package name */
    private final File f71315b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        Path path;
        OutputStream newOutputStream;
        File createTempFile = File.createTempFile("commons-compress", "packtemp");
        this.f71315b = createTempFile;
        createTempFile.deleteOnExit();
        path = createTempFile.toPath();
        newOutputStream = Files.newOutputStream(path, new OpenOption[0]);
        ((FilterOutputStream) this).out = newOutputStream;
    }
}
