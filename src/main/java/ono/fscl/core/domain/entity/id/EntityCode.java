package ono.fscl.core.domain.entity.id;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import lombok.EqualsAndHashCode;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class EntityCode {
    public final String prefix;
    public final String segmentSeparator;
    
    private final Pattern segmentPattern;

    protected static final String REGEXP = "\\d{1,4}|[A-Z]{1,4}|[a-z]{1,4}";
    
    @EqualsAndHashCode.Include
    protected List<String> segments = new ArrayList<String>();

    public EntityCode(String prefix, String groupSeparator, String groupRegEx) throws PatternSyntaxException {
        this.prefix = prefix;
        this.segmentSeparator = groupSeparator;
        this.segmentPattern = Pattern.compile(groupRegEx);
    }

    public EntityCode(String prefix, String groupSeparator) throws PatternSyntaxException {
        this.prefix = prefix;
        this.segmentSeparator = groupSeparator;
        this.segmentPattern = Pattern.compile(REGEXP);
    }

    public void addSegment(String group) throws SegmentFormatException {
        Matcher matcher = this.segmentPattern.matcher(group);
        if (matcher.matches()) {
            this.segments.add(group);
            return;
        }

        throw new SegmentFormatException(group);
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
        return b.toString();
    }
}