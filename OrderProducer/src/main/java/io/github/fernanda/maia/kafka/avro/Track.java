/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.github.fernanda.maia.kafka.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Track extends org.apache.avro.specific.SpecificRecordBase
		implements org.apache.avro.specific.SpecificRecord {
	private static final long serialVersionUID = 3470256673152119144L;
	public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse(
			"{\"type\":\"record\",\"name\":\"Track\",\"namespace\":\"io.github.fernanda.maia.kafka.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"latitude\",\"type\":\"string\"},{\"name\":\"longitude\",\"type\":\"string\"}]}");

	public static org.apache.avro.Schema getClassSchema() {
		return SCHEMA$;
	}

	private static SpecificData MODEL$ = new SpecificData();

	private static final BinaryMessageEncoder<Track> ENCODER = new BinaryMessageEncoder<Track>(MODEL$, SCHEMA$);

	private static final BinaryMessageDecoder<Track> DECODER = new BinaryMessageDecoder<Track>(MODEL$, SCHEMA$);

	/**
	 * Return the BinaryMessageEncoder instance used by this class.
	 * 
	 * @return the message encoder used by this class
	 */
	public static BinaryMessageEncoder<Track> getEncoder() {
		return ENCODER;
	}

	/**
	 * Return the BinaryMessageDecoder instance used by this class.
	 * 
	 * @return the message decoder used by this class
	 */
	public static BinaryMessageDecoder<Track> getDecoder() {
		return DECODER;
	}

	/**
	 * Create a new BinaryMessageDecoder instance for this class that uses the
	 * specified {@link SchemaStore}.
	 * 
	 * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
	 * @return a BinaryMessageDecoder instance for this class backed by the given
	 *         SchemaStore
	 */
	public static BinaryMessageDecoder<Track> createDecoder(SchemaStore resolver) {
		return new BinaryMessageDecoder<Track>(MODEL$, SCHEMA$, resolver);
	}

	/**
	 * Serializes this Track to a ByteBuffer.
	 * 
	 * @return a buffer holding the serialized data for this instance
	 * @throws java.io.IOException if this instance could not be serialized
	 */
	public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
		return ENCODER.encode(this);
	}

	/**
	 * Deserializes a Track from a ByteBuffer.
	 * 
	 * @param b a byte buffer holding serialized data for an instance of this class
	 * @return a Track instance decoded from the given buffer
	 * @throws java.io.IOException if the given bytes could not be deserialized into
	 *                             an instance of this class
	 */
	public static Track fromByteBuffer(java.nio.ByteBuffer b) throws java.io.IOException {
		return DECODER.decode(b);
	}

	private long id;
	private java.lang.CharSequence latitude;
	private java.lang.CharSequence longitude;

	/**
	 * Default constructor. Note that this does not initialize fields to their
	 * default values from the schema. If that is desired then one should use
	 * <code>newBuilder()</code>.
	 */
	public Track() {
	}

	/**
	 * All-args constructor.
	 * 
	 * @param id        The new value for id
	 * @param latitude  The new value for latitude
	 * @param longitude The new value for longitude
	 */
	public Track(java.lang.Long id, java.lang.CharSequence latitude, java.lang.CharSequence longitude) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public org.apache.avro.specific.SpecificData getSpecificData() {
		return MODEL$;
	}

	public org.apache.avro.Schema getSchema() {
		return SCHEMA$;
	}

	// Used by DatumWriter. Applications should not call.
	public java.lang.Object get(int field$) {
		switch (field$) {
		case 0:
			return id;
		case 1:
			return latitude;
		case 2:
			return longitude;
		default:
			throw new IndexOutOfBoundsException("Invalid index: " + field$);
		}
	}

	// Used by DatumReader. Applications should not call.
	@SuppressWarnings(value = "unchecked")
	public void put(int field$, java.lang.Object value$) {
		switch (field$) {
		case 0:
			id = (java.lang.Long) value$;
			break;
		case 1:
			latitude = (java.lang.CharSequence) value$;
			break;
		case 2:
			longitude = (java.lang.CharSequence) value$;
			break;
		default:
			throw new IndexOutOfBoundsException("Invalid index: " + field$);
		}
	}

	/**
	 * Gets the value of the 'id' field.
	 * 
	 * @return The value of the 'id' field.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the value of the 'id' field.
	 * 
	 * @param value the value to set.
	 */
	public void setId(long value) {
		this.id = value;
	}

	/**
	 * Gets the value of the 'latitude' field.
	 * 
	 * @return The value of the 'latitude' field.
	 */
	public java.lang.CharSequence getLatitude() {
		return latitude;
	}

	/**
	 * Sets the value of the 'latitude' field.
	 * 
	 * @param value the value to set.
	 */
	public void setLatitude(java.lang.CharSequence value) {
		this.latitude = value;
	}

	/**
	 * Gets the value of the 'longitude' field.
	 * 
	 * @return The value of the 'longitude' field.
	 */
	public java.lang.CharSequence getLongitude() {
		return longitude;
	}

	/**
	 * Sets the value of the 'longitude' field.
	 * 
	 * @param value the value to set.
	 */
	public void setLongitude(java.lang.CharSequence value) {
		this.longitude = value;
	}

	/**
	 * Creates a new Track RecordBuilder.
	 * 
	 * @return A new Track RecordBuilder
	 */
	public static io.github.fernanda.maia.kafka.avro.Track.Builder newBuilder() {
		return new io.github.fernanda.maia.kafka.avro.Track.Builder();
	}

	/**
	 * Creates a new Track RecordBuilder by copying an existing Builder.
	 * 
	 * @param other The existing builder to copy.
	 * @return A new Track RecordBuilder
	 */
	public static io.github.fernanda.maia.kafka.avro.Track.Builder newBuilder(
			io.github.fernanda.maia.kafka.avro.Track.Builder other) {
		if (other == null) {
			return new io.github.fernanda.maia.kafka.avro.Track.Builder();
		} else {
			return new io.github.fernanda.maia.kafka.avro.Track.Builder(other);
		}
	}

	/**
	 * Creates a new Track RecordBuilder by copying an existing Track instance.
	 * 
	 * @param other The existing instance to copy.
	 * @return A new Track RecordBuilder
	 */
	public static io.github.fernanda.maia.kafka.avro.Track.Builder newBuilder(
			io.github.fernanda.maia.kafka.avro.Track other) {
		if (other == null) {
			return new io.github.fernanda.maia.kafka.avro.Track.Builder();
		} else {
			return new io.github.fernanda.maia.kafka.avro.Track.Builder(other);
		}
	}

	/**
	 * RecordBuilder for Track instances.
	 */
	@org.apache.avro.specific.AvroGenerated
	public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Track>
			implements org.apache.avro.data.RecordBuilder<Track> {

		private long id;
		private java.lang.CharSequence latitude;
		private java.lang.CharSequence longitude;

		/** Creates a new Builder */
		private Builder() {
			super(SCHEMA$);
		}

		/**
		 * Creates a Builder by copying an existing Builder.
		 * 
		 * @param other The existing Builder to copy.
		 */
		private Builder(io.github.fernanda.maia.kafka.avro.Track.Builder other) {
			super(other);
			if (isValidValue(fields()[0], other.id)) {
				this.id = data().deepCopy(fields()[0].schema(), other.id);
				fieldSetFlags()[0] = other.fieldSetFlags()[0];
			}
			if (isValidValue(fields()[1], other.latitude)) {
				this.latitude = data().deepCopy(fields()[1].schema(), other.latitude);
				fieldSetFlags()[1] = other.fieldSetFlags()[1];
			}
			if (isValidValue(fields()[2], other.longitude)) {
				this.longitude = data().deepCopy(fields()[2].schema(), other.longitude);
				fieldSetFlags()[2] = other.fieldSetFlags()[2];
			}
		}

		/**
		 * Creates a Builder by copying an existing Track instance
		 * 
		 * @param other The existing instance to copy.
		 */
		private Builder(io.github.fernanda.maia.kafka.avro.Track other) {
			super(SCHEMA$);
			if (isValidValue(fields()[0], other.id)) {
				this.id = data().deepCopy(fields()[0].schema(), other.id);
				fieldSetFlags()[0] = true;
			}
			if (isValidValue(fields()[1], other.latitude)) {
				this.latitude = data().deepCopy(fields()[1].schema(), other.latitude);
				fieldSetFlags()[1] = true;
			}
			if (isValidValue(fields()[2], other.longitude)) {
				this.longitude = data().deepCopy(fields()[2].schema(), other.longitude);
				fieldSetFlags()[2] = true;
			}
		}

		/**
		 * Gets the value of the 'id' field.
		 * 
		 * @return The value.
		 */
		public long getId() {
			return id;
		}

		/**
		 * Sets the value of the 'id' field.
		 * 
		 * @param value The value of 'id'.
		 * @return This builder.
		 */
		public io.github.fernanda.maia.kafka.avro.Track.Builder setId(long value) {
			validate(fields()[0], value);
			this.id = value;
			fieldSetFlags()[0] = true;
			return this;
		}

		/**
		 * Checks whether the 'id' field has been set.
		 * 
		 * @return True if the 'id' field has been set, false otherwise.
		 */
		public boolean hasId() {
			return fieldSetFlags()[0];
		}

		/**
		 * Clears the value of the 'id' field.
		 * 
		 * @return This builder.
		 */
		public io.github.fernanda.maia.kafka.avro.Track.Builder clearId() {
			fieldSetFlags()[0] = false;
			return this;
		}

		/**
		 * Gets the value of the 'latitude' field.
		 * 
		 * @return The value.
		 */
		public java.lang.CharSequence getLatitude() {
			return latitude;
		}

		/**
		 * Sets the value of the 'latitude' field.
		 * 
		 * @param value The value of 'latitude'.
		 * @return This builder.
		 */
		public io.github.fernanda.maia.kafka.avro.Track.Builder setLatitude(java.lang.CharSequence value) {
			validate(fields()[1], value);
			this.latitude = value;
			fieldSetFlags()[1] = true;
			return this;
		}

		/**
		 * Checks whether the 'latitude' field has been set.
		 * 
		 * @return True if the 'latitude' field has been set, false otherwise.
		 */
		public boolean hasLatitude() {
			return fieldSetFlags()[1];
		}

		/**
		 * Clears the value of the 'latitude' field.
		 * 
		 * @return This builder.
		 */
		public io.github.fernanda.maia.kafka.avro.Track.Builder clearLatitude() {
			latitude = null;
			fieldSetFlags()[1] = false;
			return this;
		}

		/**
		 * Gets the value of the 'longitude' field.
		 * 
		 * @return The value.
		 */
		public java.lang.CharSequence getLongitude() {
			return longitude;
		}

		/**
		 * Sets the value of the 'longitude' field.
		 * 
		 * @param value The value of 'longitude'.
		 * @return This builder.
		 */
		public io.github.fernanda.maia.kafka.avro.Track.Builder setLongitude(java.lang.CharSequence value) {
			validate(fields()[2], value);
			this.longitude = value;
			fieldSetFlags()[2] = true;
			return this;
		}

		/**
		 * Checks whether the 'longitude' field has been set.
		 * 
		 * @return True if the 'longitude' field has been set, false otherwise.
		 */
		public boolean hasLongitude() {
			return fieldSetFlags()[2];
		}

		/**
		 * Clears the value of the 'longitude' field.
		 * 
		 * @return This builder.
		 */
		public io.github.fernanda.maia.kafka.avro.Track.Builder clearLongitude() {
			longitude = null;
			fieldSetFlags()[2] = false;
			return this;
		}

		@Override
		@SuppressWarnings("unchecked")
		public Track build() {
			try {
				Track record = new Track();
				record.id = fieldSetFlags()[0] ? this.id : (java.lang.Long) defaultValue(fields()[0]);
				record.latitude = fieldSetFlags()[1] ? this.latitude
						: (java.lang.CharSequence) defaultValue(fields()[1]);
				record.longitude = fieldSetFlags()[2] ? this.longitude
						: (java.lang.CharSequence) defaultValue(fields()[2]);
				return record;
			} catch (org.apache.avro.AvroMissingFieldException e) {
				throw e;
			} catch (java.lang.Exception e) {
				throw new org.apache.avro.AvroRuntimeException(e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumWriter<Track> WRITER$ = (org.apache.avro.io.DatumWriter<Track>) MODEL$
			.createDatumWriter(SCHEMA$);

	@Override
	public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException {
		WRITER$.write(this, SpecificData.getEncoder(out));
	}

	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumReader<Track> READER$ = (org.apache.avro.io.DatumReader<Track>) MODEL$
			.createDatumReader(SCHEMA$);

	@Override
	public void readExternal(java.io.ObjectInput in) throws java.io.IOException {
		READER$.read(this, SpecificData.getDecoder(in));
	}

	@Override
	protected boolean hasCustomCoders() {
		return true;
	}

	@Override
	public void customEncode(org.apache.avro.io.Encoder out) throws java.io.IOException {
		out.writeLong(this.id);

		out.writeString(this.latitude);

		out.writeString(this.longitude);

	}

	@Override
	public void customDecode(org.apache.avro.io.ResolvingDecoder in) throws java.io.IOException {
		org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
		if (fieldOrder == null) {
			this.id = in.readLong();

			this.latitude = in.readString(this.latitude instanceof Utf8 ? (Utf8) this.latitude : null);

			this.longitude = in.readString(this.longitude instanceof Utf8 ? (Utf8) this.longitude : null);

		} else {
			for (int i = 0; i < 3; i++) {
				switch (fieldOrder[i].pos()) {
				case 0:
					this.id = in.readLong();
					break;

				case 1:
					this.latitude = in.readString(this.latitude instanceof Utf8 ? (Utf8) this.latitude : null);
					break;

				case 2:
					this.longitude = in.readString(this.longitude instanceof Utf8 ? (Utf8) this.longitude : null);
					break;

				default:
					throw new java.io.IOException("Corrupt ResolvingDecoder.");
				}
			}
		}
	}
}
