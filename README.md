# Kata 2 — Input and Output in Java

## Objective

Practice using `InputStream` and `OutputStream` to read tabular data, transform it into objects, and generate a summary without coupling the processing logic to a specific input source or output destination.

The program reads employee data, extracts each employee's name and gender, and counts the number of employees of each gender.

## Requirements

- Represent each row as a domain entity.
- Use a loading interface based on `InputStream`.
- Read data from at least two different sources.
- Write results through an `OutputStream`.
- Support at least two output destinations.
- Separate input, transformation, summary calculation, and output responsibilities.
- Display understandable error messages when problems occur.

## Technologies

- Java.
- Maven.
- JUnit 4 for automated tests, if the test dependency is configured.
- A JDK compatible with the version configured in `pom.xml`.

## Project Structure

The main classes are located in `src/main/java/software/ulpgc/`.

- `Main`: connects the components and configures the input source and output destination.
- `Employee`: represents an employee using their name and gender.
- `Gender`: defines the supported genders and converts text into an enum value.
- `EmployeeLoader`: interface for loading employees from an `InputStream`.
- `TsvEmployeeLoader`: reads TSV data, skips the header, and transforms rows into `Employee` objects.
- `EmployeeSource`: interface for opening an input source.
- `FileEmployeeSource`: reads data from a local file.
- `UrlEmployeeSource`: reads data from a URL.
- `EmployeeSummaryWriter`: counts employees by gender and writes the summary to an `OutputStream`.

## Compilation

A compatible JDK and Maven installation are required.

From the project root directory, run:

```bash
mvn clean compile
```

## Execution

To use the default URL and print the summary to the console:

```bash
mvn exec:java -Dexec.mainClass="software.ulpgc.Main"
```

To read from a local file and print the summary to the console:

```bash
mvn exec:java -Dexec.mainClass="software.ulpgc.Main" -Dexec.args="employees.tsv"
```

To read from a local file and save the summary to another file:

```bash
mvn exec:java -Dexec.mainClass="software.ulpgc.Main" -Dexec.args="employees.tsv summary.txt"
```

A URL can also be provided as the first argument, with an output filename as the second argument.

The expected input format is TSV, with columns separated by tab characters. The first row is treated as the header. The program reads the employee name from the first column and the gender from the sixth column.

## Example Output

```text
Male: 3
Female: 2
```

The numbers depend on the input data.

## Design and Responsibilities

The program separates data access, input interpretation, and summary generation.

`FileEmployeeSource` and `UrlEmployeeSource` allow the input source to be changed without modifying the employee-processing logic. `TsvEmployeeLoader` interprets the input format and creates domain objects. `EmployeeSummaryWriter` receives a collection of employees and writes the summary to the supplied output stream.

The output destination can be changed between the console and a file without changing the summary calculation logic.

## Verification

The following cases should be tested:

- Reading a valid TSV file.
- Reading data from a URL.
- Writing the summary to the console.
- Writing the summary to a file.
- Handling a missing input file.
- Handling an invalid or inaccessible URL.
- Handling an empty file.
- Handling malformed rows or invalid gender values.
- Verifying that changing row order does not change the summary.
- Verifying that the same data produces the same summary regardless of the input source.

Document the actual results after running the tests.

## Kata Repetitions

The kata must be repeated at least three times with an equivalent scope.

- **Iteration 1:** [Describe the first implementation.]
- **Iteration 2:** [Describe the changes made in the second implementation.]
- **Iteration 3:** [Describe the changes made in the third implementation.]

The repository commits should make the different iterations identifiable.

## Explanatory Video

**Video link:** [Add the video link here.]

Maximum duration: 7 minutes.

The video should explain the use of `InputStream` and `OutputStream`, the transformation of rows into objects, reading from different sources, changing the output destination, error handling, and how to extend the program with new adapters.

## Repository

Public repository: https://github.com/Galaxy-385/Kata2
