package org.mvel2.templates.res;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import org.mvel2.ParserContext;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.templates.CompiledTemplate;
import r10.b;
import s10.c;
import s10.d;

/* loaded from: classes7.dex */
public class CompiledIncludeNode extends Node {
    private CompiledTemplate cFileCache;
    private Serializable cIncludeExpression;
    private Serializable cPreExpression;
    private ParserContext context;
    private long fileDateStamp;

    public CompiledIncludeNode(int i11, String str, char[] cArr, int i12, int i13, ParserContext parserContext) {
        this.begin = i11;
        this.name = str;
        this.contents = cArr;
        this.cStart = i12;
        this.cEnd = i13 - 1;
        this.end = i13;
        this.context = parserContext;
        int a11 = d.a(cArr, i12);
        char[] cArr2 = this.contents;
        int i14 = this.cStart;
        this.cIncludeExpression = org.mvel2.d.g(cArr2, i14, a11 - i14, parserContext);
        char[] cArr3 = this.contents;
        if (a11 != cArr3.length) {
            int i15 = a11 + 1;
            this.cPreExpression = org.mvel2.d.g(cArr3, i15, this.cEnd - i15, parserContext);
        }
    }

    private static FileInputStream openInputStream(File file) throws IOException {
        if (file == null) {
            throw new FileNotFoundException("file parameter is null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        if (file.canRead()) {
            return new FileInputStream(file);
        }
        throw new IOException("File '" + file + "' cannot be read");
    }

    private String readFile(r10.d dVar, String str, Object obj, VariableResolverFactory variableResolverFactory) {
        File file = new File(String.valueOf(dVar.i().k()) + "/" + str);
        long j11 = this.fileDateStamp;
        if (j11 == 0 || j11 != file.lastModified()) {
            this.fileDateStamp = file.lastModified();
            this.cFileCache = b.g(readInFile(dVar, file), this.context);
        }
        return String.valueOf(r10.d.d(this.cFileCache, obj, variableResolverFactory));
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String readInFile(r10.d r9, java.io.File r10) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.templates.res.CompiledIncludeNode.readInFile(r10.d, java.io.File):java.lang.String");
    }

    @Override // org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        return false;
    }

    @Override // org.mvel2.templates.res.Node
    public Object eval(r10.d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        String str = (String) org.mvel2.d.u(this.cIncludeExpression, obj, variableResolverFactory, String.class);
        Serializable serializable = this.cPreExpression;
        if (serializable != null) {
            org.mvel2.d.t(serializable, obj, variableResolverFactory);
        }
        Node node = this.next;
        return node != null ? node.eval(dVar, cVar.append(String.valueOf(r10.d.a(readFile(dVar, str, obj, variableResolverFactory), obj, variableResolverFactory))), obj, variableResolverFactory) : cVar.append(String.valueOf(org.mvel2.d.n(readFile(dVar, str, obj, variableResolverFactory), obj, variableResolverFactory)));
    }
}
