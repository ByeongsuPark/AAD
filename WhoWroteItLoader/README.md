# AsyncTaskLoader
 When you need to perform background operations in Android,
 you usually use AsyncTask.
 
 But If you use AsyncTask, it cannot update the UI 
 if a configuration change(ex:rotation) occurs while the background task is running.
 
 To address this situation, You can use a set of classes called loaders designed specifically for loading
 data into the UI asynchronously.
 
 The Loader framework does the work for you by reassociating the loader with the
 appropriate Activity when the device changes its coniguration.
 
 This means that if you rotate the device while the task is still running,
 the results will be displayed correctly in the Activity once the data is returned.