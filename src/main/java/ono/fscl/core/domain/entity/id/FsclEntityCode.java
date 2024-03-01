package ono.fscl.core.domain.entity.id;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import lombok.EqualsAndHashCode;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class FsclEntityCode {
    public final String prefix;
    public final String postfix;
    public final String segmentSeparator;
    
    private final Pattern segmentPattern;

    protected static final String REGEXP = "\\d{1,4}|[A-Z]{1,4}|[a-z]{1,4}";
    
    @EqualsAndHashCode.Include
    protected List<String> segments = new ArrayList<String>();

    public FsclEntityCode(String prefix, String postfix, List<String> segments, String segmentSeparator, String groupRegEx)
        throws SegmentFormatException, PatternSyntaxException  {
        this.prefix = prefix;
        this.postfix = postfix;
        this.segmentSeparator = segmentSeparator;
        this.segmentPattern = Pattern.compile(groupRegEx);
        this.addSegments(segments);

    }

    public FsclEntityCode(String prefix, String postfix, List<String> segments, String segmentSeparator) throws SegmentFormatException, PatternSyntaxException {
        this.prefix = prefix;
        this.postfix = postfix;
        this.segmentSeparator = segmentSeparator;
        this.segmentPattern = Pattern.compile(REGEXP);
        this.addSegments(segments);
    }

    public static abstract class Builder<T extends FsclEntityCode> {
        protected boolean isShadow = false;
        protected final List<String> segms;
        public Builder() {
            segms = new ArrayList<>();
        }

        public Builder<T> withSegment(String segment) {
            this.segms.add(segment);
            return this;
        }

        public Builder<T> asShadow() {
            this.isShadow = true;
            return this;
        }
        public abstract T build() throws SegmentFormatException;
    }

    private void addSegments(List<String> segments) throws SegmentFormatException {
        Iterator<String> iter = segments.iterator();

        while (iter.hasNext()) {
            String s = iter.next();
            Matcher matcher = this.segmentPattern.matcher(s);
            if (matcher.matches()) {
                this.segments.add(s);;
            }
            else {
                throw new SegmentFormatException(s);
            }
        }
    }
    
    public String toString() {
        StringBuilder b = new StringBuilder(prefix);

        Iterator<String> iter = segments.iterator();

        if (iter.hasNext() ) {
            b.append(iter.next());
        }

        while (iter.hasNext()) {
            b.append(this.segmentSeparator);
            b.append(iter.next());
        }

        if(this.postfix != null) {
            b.append(this.postfix);
        }

        return b.toString();
    }
}