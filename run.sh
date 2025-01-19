javac -d target -cp src $(find src -name "*.java")
java -cp target com.lms.Utils.LibraryManager