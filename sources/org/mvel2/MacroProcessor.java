package org.mvel2;

import java.util.Map;
import org.mvel2.compiler.AbstractParser;
import org.mvel2.util.m;

/* loaded from: classes7.dex */
public class MacroProcessor extends AbstractParser {
    private Map<String, Object> macros;

    public MacroProcessor() {
    }

    public MacroProcessor(Map<String, Object> map) {
        this.macros = map;
    }

    public void captureToWhitespace() {
        while (true) {
            int i11 = this.cursor;
            if (i11 >= this.length || m.q0(this.expr[i11])) {
                return;
            } else {
                this.cursor++;
            }
        }
    }

    public Map<String, Object> getMacros() {
        return this.macros;
    }

    public String parse(String str) {
        return new String(parse(str.toCharArray()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0105, code lost:
    
        if (r2 != '{') goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public char[] parse(char[] r10) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mvel2.MacroProcessor.parse(char[]):char[]");
    }

    public void setMacros(Map<String, Object> map) {
        this.macros = map;
    }
}
