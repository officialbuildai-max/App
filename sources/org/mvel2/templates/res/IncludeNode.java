package org.mvel2.templates.res;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.mvel2.integration.VariableResolverFactory;
import org.mvel2.templates.TemplateError;
import s10.c;
import s10.d;

/* loaded from: classes7.dex */
public class IncludeNode extends Node {
    int includeOffset;
    int includeStart;
    int preOffset;
    int preStart;

    public IncludeNode(int i11, String str, char[] cArr, int i12, int i13) {
        this.begin = i11;
        this.name = str;
        this.contents = cArr;
        this.cStart = i12;
        this.cEnd = i13 - 1;
        this.end = i13;
        int a11 = d.a(cArr, 0);
        int i14 = this.cStart;
        this.includeStart = i14;
        this.includeOffset = a11 - i14;
        int i15 = a11 + 1;
        this.preStart = i15;
        this.preOffset = this.cEnd - i15;
    }

    public static String readInFile(r10.d dVar, String str) {
        File file = new File(String.valueOf(dVar.i().k()) + "/" + str);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            dVar.i().q(file.getParent());
            byte[] bArr = new byte[10];
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    bufferedInputStream.close();
                    fileInputStream.close();
                    dVar.i().n();
                    return sb2.toString();
                }
                for (int i11 = 0; i11 < read; i11++) {
                    sb2.append((char) bArr[i11]);
                }
            }
        } catch (FileNotFoundException unused) {
            throw new TemplateError("cannot include template '" + str + "': file not found.");
        } catch (IOException e11) {
            throw new TemplateError("unknown I/O exception while including '" + str + "' (stacktrace nested)", e11);
        }
    }

    @Override // org.mvel2.templates.res.Node
    public boolean demarcate(Node node, char[] cArr) {
        return false;
    }

    @Override // org.mvel2.templates.res.Node
    public Object eval(r10.d dVar, c cVar, Object obj, VariableResolverFactory variableResolverFactory) {
        String str = (String) org.mvel2.d.r(this.contents, this.includeStart, this.includeOffset, obj, variableResolverFactory, String.class);
        int i11 = this.preOffset;
        if (i11 != 0) {
            org.mvel2.d.q(this.contents, this.preStart, i11, obj, variableResolverFactory);
        }
        Node node = this.next;
        return node != null ? node.eval(dVar, cVar.append(String.valueOf(r10.d.a(readInFile(dVar, str), obj, variableResolverFactory))), obj, variableResolverFactory) : cVar.append(String.valueOf(org.mvel2.d.n(readInFile(dVar, str), obj, variableResolverFactory)));
    }
}
