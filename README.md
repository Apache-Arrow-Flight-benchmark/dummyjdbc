# dummyjdbc 

This fork enables storing the contents of the read CSV in RAM for fast access. Additionally, it implements several metadata methods required for executing `discovery` and `doGet` on an Apache Arrow Flight server created using [IBM Cloud Pak for Data - Connector SDK](https://github.com/IBM/cp4d-connector-sdk) with the Generic JDBC connector. Some metadata is hard-coded, but it does not interfere with the server functionality.

## Data

DummyJDBC reads data from a CSV file. The path to the file must be specified in an environment variable `CSV_FILE_PATH`. Storing only one table is supported: the metadata desctibes it as `mock` table in `mock` database, but it is irrevelant for accessing data.

The CSV file consists of 3 elements:

   * number of repetitions,
   * headers,
   * actual data.

### Number of repetitions

Specified in the first line of the CSV file. It is single integer number denoting how many more times the data should be repeatedly returned (if 0, the contents of the file will be returned once).

### Headers

The headers of the table follow a specific pattern, to enable inferring the column data type from them. Each elemnt should start with the name of the data type followed by `_` and subsequently any string of characters that assures uniqueness, for example `varchar_0`, `varchar_1`, etc.

The supported types are:
 * `varchar`,
 * `decimal(7,2)` (the length is hardcoded, enabling variable length requires development),
 * `double`,
 * `date`,
 * `decimal`.

Any other type will be read as `java.lang.String`, so for example `char` columns can be used when wrapped in a required amount of whitespaces.

The headers should be provided in the second line of the CSV file and should be separated with the `|` character.

### Actual data

Rows separated by `|`. It must be possible to convert each column from string to a type specified in the corresponding header.

### Example

See the [example_data](/example_data/) folder for an example of the CSV file (`store_sales` table, a part of the TPC-DS benchmark).

## More information

For more details see the original [Wiki](https://github.com/kaiwinter/dummyjdbc/wiki)
