# Add Delete functionality to Student List

The goal is to allow users to delete students from the list in Lesson 21 Task 1.

## Proposed Changes

### [UI Layout](file:///C:/Users/Azamat/AndroidStudioProjects/TMS_ANDROID/app/src/main/res/layout/student_item.xml)

#### [MODIFY] [student_item.xml](file:///C:/Users/Azamat/AndroidStudioProjects/TMS_ANDROID/app/src/main/res/layout/student_item.xml)
- Add a "Delete" button to each student item.

### [Adapter](file:///C:/Users/Azamat/AndroidStudioProjects/TMS_ANDROID/app/src/main/java/com/example/tms_android/Lessons/Lesson21/Task1/StudentAdapter.kt)

#### [MODIFY] [StudentAdapter.kt](file:///C:/Users/Azamat/AndroidStudioProjects/TMS_ANDROID/app/src/main/java/com/example/tms_android/Lessons/Lesson21/Task1/StudentAdapter.kt)
- Add a `onDeleteClick` callback to the adapter constructor.
- Bind the delete button click listener in `onBindViewHolder`.

### [Activity](file:///C:/Users/Azamat/AndroidStudioProjects/TMS_ANDROID/app/src/main/java/com/example/tms_android/Lessons/Lesson21/Task1/Lesson21Task1.kt)

#### [MODIFY] [Lesson21Task1.kt](file:///C:/Users/Azamat/AndroidStudioProjects/TMS_ANDROID/app/src/main/java/com/example/tms_android/Lessons/Lesson21/Task1/Lesson21Task1.kt)
- Fix the Activity logic (which appears to have been reset or is out of sync) to include input fields and the "Add" button logic.
- Implement the `onDeleteClick` callback to remove the student from the list and update the adapter.

## Verification Plan

### Automated Tests
- Build the project using `gradlew :app:assembleDebug`.

### Manual Verification
- Add a few students.
- Click the "Delete" button on one of the students and verify they are removed from the list.
- Verify that if all students are deleted, the "No data" message reappears.
