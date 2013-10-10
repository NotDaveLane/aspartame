package net.dlane.aspartame.service.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * Excludes fields inherited from Sugar ORM in GSON serialization/deserialization.
 */
public class SugarExclusionStrategy implements ExclusionStrategy {

    @Override
    public boolean shouldSkipClass( Class<?> type ) {

        return false;
    }

    /**
     * Indicates that fields used by Sugar ORM should be skipped.
     */
    @Override
    public boolean shouldSkipField( FieldAttributes fieldAttributes ) {

        if ( "application".equals( fieldAttributes.getName() ) ) {
            return true;
        }
        if ( "context".equals( fieldAttributes.getName() ) ) {
            return true;
        }
        if ( "database".equals( fieldAttributes.getName() ) ) {
            return true;
        }
        if ( "id".equals( fieldAttributes.getName() ) ) {
            return true;
        }
        if ( "tableName".equals( fieldAttributes.getName() ) ) {
            return true;
        }

        return false;
    }
}
