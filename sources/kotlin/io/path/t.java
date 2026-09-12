package kotlin.io.path;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class t extends PathsKt__PathRecursiveFunctionsKt {
    public static final String b(Path path) {
        Path fileName;
        Intrinsics.h(path, "<this>");
        fileName = path.getFileName();
        String obj = fileName != null ? fileName.toString() : null;
        return obj == null ? "" : obj;
    }

    public static final List c(Path path, String glob) {
        DirectoryStream newDirectoryStream;
        Intrinsics.h(path, "<this>");
        Intrinsics.h(glob, "glob");
        newDirectoryStream = Files.newDirectoryStream(path, glob);
        try {
            DirectoryStream a11 = s.a(newDirectoryStream);
            Intrinsics.e(a11);
            List R0 = CollectionsKt.R0(a11);
            CloseableKt.a(newDirectoryStream, null);
            return R0;
        } finally {
        }
    }

    public static /* synthetic */ List d(Path path, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "*";
        }
        return c(path, str);
    }
}
