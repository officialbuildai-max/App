package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
final class e extends SimpleFileVisitor {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f67382a;

    /* renamed from: b, reason: collision with root package name */
    private h f67383b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayDeque f67384c = new ArrayDeque();

    public e(boolean z10) {
        this.f67382a = z10;
    }

    public FileVisitResult a(Path dir, BasicFileAttributes attrs) {
        Object fileKey;
        Intrinsics.h(dir, "dir");
        Intrinsics.h(attrs, "attrs");
        fileKey = attrs.fileKey();
        this.f67384c.add(new h(dir, fileKey, this.f67383b));
        FileVisitResult preVisitDirectory = super.preVisitDirectory(dir, attrs);
        Intrinsics.g(preVisitDirectory, "preVisitDirectory(...)");
        return preVisitDirectory;
    }

    public final List b(h directoryNode) {
        Intrinsics.h(directoryNode, "directoryNode");
        this.f67383b = directoryNode;
        Files.walkFileTree(directoryNode.d(), LinkFollowing.f67373a.b(this.f67382a), 1, b.a(this));
        this.f67384c.removeFirst();
        ArrayDeque arrayDeque = this.f67384c;
        this.f67384c = new ArrayDeque();
        return arrayDeque;
    }

    public FileVisitResult c(Path file, BasicFileAttributes attrs) {
        Intrinsics.h(file, "file");
        Intrinsics.h(attrs, "attrs");
        this.f67384c.add(new h(file, null, this.f67383b));
        FileVisitResult visitFile = super.visitFile(file, attrs);
        Intrinsics.g(visitFile, "visitFile(...)");
        return visitFile;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes) {
        return a(a.a(obj), basicFileAttributes);
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public /* bridge */ /* synthetic */ FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) {
        return c(a.a(obj), basicFileAttributes);
    }
}
